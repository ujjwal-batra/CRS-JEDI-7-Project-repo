/**
 *
 */
package com.crs.flipkart.restController;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.business.CourseOperationService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/professor")
public class ProfessorRestAPI {

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response professorLogin(Professor professor) {
        ProfessorInterface professorObj = new ProfessorService();
        int response = professorObj.checkCredentials(professor.getEmailId(), professor.getPassword());
        if (response != -1) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(200).entity("Invalid credentials").build();
    }


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
        return Response.status(200).entity(res).build();
    }

    @GET
    @Path("/showMyCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showMyCourses(@QueryParam("professorId") int professorId) {

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
        return Response.status(200).entity(res).build();
    }

    @GET
    @Path("/viewStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewStudents(@QueryParam("professorId") int professorId) {
        List<String> res = new ArrayList<>();
        List<String> studentList = new ProfessorService().viewStudentsForAllCourses(professorId);
        if (studentList.isEmpty()) return Response.status(200).entity("No Students enrolled").build();
        res.add("Student details: ");
        res.addAll(studentList);

        return Response.status(200).entity(res).build();
    }

    @GET
    @Path("/addGrade")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addGrade(@QueryParam("professorId") int professorId,
                             @QueryParam("studentId") int studentId,
                             @QueryParam("courseId") int courseId,
                             @QueryParam("marks") int marks) {

        viewStudents(professorId);
        new ProfessorService().addGrade(courseId, studentId, marks);
        return Response.status(200).entity("Successfully Added").build();
    }

    @GET
    @Path("/selectCourseToTeach")
    @Produces(MediaType.TEXT_PLAIN)
    public Response selectCourseToTeach(@QueryParam("professorId") int professorId,
                                        @QueryParam("courseId") int courseId) {
        new ProfessorService().selectCourseToTeach(courseId, professorId);
        return Response.status(200).entity("Successfully Registered").build();
    }


}
