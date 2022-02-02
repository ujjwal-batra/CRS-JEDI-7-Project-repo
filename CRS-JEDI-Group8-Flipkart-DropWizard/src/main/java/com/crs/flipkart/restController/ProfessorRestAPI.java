/**
 *
 */
package com.crs.flipkart.restController;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.business.CourseOperationService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exceptions.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * API End points for Professor
 */
@Path("/professor")
public class ProfessorRestAPI {


    private static final Logger logger = LogManager.getLogger(ProfessorRestAPI.class);

    /**
     *
     * Endpoint for verifying professor login credentials
     *
     * @param professor
     * @return
     */
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response professorLogin(Professor professor) {
        logger.info("Login request: " + professor.getEmailId());
        ProfessorInterface professorObj = new ProfessorService();
        try {
            professorObj.checkCredentials(professor.getEmailId(), professor.getPassword());
            logger.info("Login successful");
            return Response.status(200).entity("Login successful").build();
        } catch (InvalidCredentialsException exception) {
            logger.error(exception.getMessage());
            return Response.status(200).entity(exception.getMessage()).build();
        }
    }


    /**
     * Endpoint to retrieve course catalogue
     * @return
     */
    @GET
    @Path("/showCourseCatalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showCourseCatalogue() {
        List<Course> courseList = new CourseOperationService().getCourseCatalogue().getCourseList();
        List<String> res = new ArrayList<>();
        courseList.forEach(course -> {
            res.add("CourseId: " + course.getCourseId() +
                    ", CourseName: " + course.getCourseName() +
                    ", Professor: " + (course.getProfessorId() == -1 || course.getProfessorId() == 0 ? "Not yet assigned" : course.getProfessorId()));
        });
        logger.info("API success for show catalogue, by professor");
        return Response.status(200).entity(res).build();
    }

    /**
     * Endpoint to retrieve professor's course details
     * @param professorId
     * @return
     */
    @GET
    @Path("/showMyCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showMyCourses(@QueryParam("professorId") int professorId) {
        try {
            List<String> res = new ArrayList<>();
            Professor professor = new ProfessorService().getProfessorById(professorId);
            if (professor.getCourseList().isEmpty())
                return Response.status(200).entity("Not yet registered for any course").build();
            res.add("My Course details: ");
            professor.getCourseList().forEach(course -> {
                res.add("CourseId: " + course.getCourseId() +
                        ", CourseName: " + course.getCourseName() +
                        ", ProfessorId: " + course.getProfessorId());
            });
            logger.info("API success for show course of professor");
            return Response.status(200).entity(res).build();
        } catch (ProfessorNotFoundException exception) {
            logger.error(exception.getMessage());
            return Response.status(200).entity(exception.getMessage()).build();
        }
    }

    /**
     * Endpoint to retrieve registered students details
     * @param professorId
     * @return
     */
    @GET
    @Path("/viewStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewStudents(@QueryParam("professorId") int professorId) {
        List<String> res = new ArrayList<>();
        List<String> studentList = new ProfessorService().viewStudentsForAllCourses(professorId);
        if (studentList.isEmpty()) return Response.status(200).entity("No Students enrolled").build();
        res.add("Student details: ");
        res.addAll(studentList);
        logger.info("API success for view enrolled students of professor");
        return Response.status(200).entity(res).build();
    }

    /**
     * Endpoint to add grade for a particular student
     * @param professorId
     * @param studentId
     * @param courseId
     * @param marks
     * @return
     */
    @GET
    @Path("/addGrade")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addGrade(@QueryParam("professorId") int professorId,
                             @QueryParam("studentId") int studentId,
                             @QueryParam("courseId") int courseId,
                             @QueryParam("marks") int marks) {
        try {
            new ProfessorService().addGrade(courseId, studentId, marks);
            logger.info("API success for add grade");
            return Response.status(200).entity("Successfully Added").build();
        } catch (GradeNotAddedException exception) {
            logger.error(exception.getMessage());
            return Response.status(200).entity(exception.getMessage()).build();
        } catch (UserNotFoundException exception) {
            logger.error(exception.getMessage());
            return Response.status(200).entity(exception.getMessage()).build();
        } catch (CourseNotFoundException exception) {
            logger.error(exception.getMessage());
            return Response.status(200).entity(exception.getMessage()).build();
        }
    }

    /**
     * Endpoint to register for a course to teach
     * @param professorId
     * @param courseId
     * @return
     */
    @GET
    @Path("/selectCourseToTeach")
    @Produces(MediaType.TEXT_PLAIN)
    public Response selectCourseToTeach(@QueryParam("professorId") int professorId,
                                        @QueryParam("courseId") int courseId) {
        try {
            new ProfessorService().selectCourseToTeach(courseId, professorId);
            logger.info("API success for select course to teach");
            return Response.status(200).entity("Successfully Registered").build();
        } catch (CourseNotAssignedToProfessorException exception) {
            logger.error(exception.getMessage());
            return Response.status(200).entity(exception.getMessage()).build();
        }
    }


}
