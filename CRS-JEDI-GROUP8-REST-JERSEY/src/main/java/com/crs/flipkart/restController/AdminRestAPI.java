/**
 * 
 */
package com.crs.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.business.CourseOperationService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseNotEnrolledException;

/**
 * @author Adarsh
 *
 */

@Path("/admin")
public class AdminRestAPI {
	
	/**
	 * 
	 * REST-service for admin Login
	 * @param Admin object
	 * @return
	 */
	@POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response adminLogin(Admin admin) {
        AdminServiceInterface adminObj = new AdminService();
        int response = adminObj.checkCredentials(admin.getEmailId(), admin.getPassword());
        if (response != -1) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(200).entity("Invalid credentials").build();
    }
	
	/**
	 * 
	 * REST-service for assigning course to professor
	 * @param courseCode
	 * @param professorId
	 * @return
	 */
	@POST
	@Path("/addCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(@NotNull @QueryParam("courseId") int courseId,
							  @NotNull @QueryParam("courseName") String courseName) {
		try {
		 AdminServiceInterface adminServiceInterface = new AdminService();
		 adminServiceInterface.addCourse(courseId, courseName);
		 return Response.status(201).entity("Course with courseID: " + courseId + " added to catalog").build();
		 
		}
		catch(AddCourseException ex) {
			return Response.status(409).entity(ex.getMessage()).build();
		}
		 
	}
	
	/**
	 * 
	 * REST-service to show course catalog
	 * @param 
	 * @return List of all courses
	 */
	@GET
	@Path("/showCoursesCatalogue")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showCourseCatalogue() {
		 List<Course> courseList = new CourseOperationService().getCourseCatalogue().getCourseList();
		 List<String> result = new ArrayList<String>();
		 courseList.forEach(course -> {
	            result.add("CourseId: " + course.getCourseId() +
	                    ", CourseName: " + course.getCourseName() +
	                    ", Professor: " + (course.getProfessorId() == -1 || course.getProfessorId() == 0 ? "Not yet assigned" : course.getProfessorId()));
	        });
	        return Response.status(200).entity(result).build();
		 
	}
	
	/**
	 * 
	 * REST-service to delete Course by admin
	 * @param CourseCode
	 * @return 
	 */
	@PUT
	@Path("/deleteCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCourse(@NotNull
								 @QueryParam("courseCode") int courseCode) {
		CourseNotEnrolledException courseNotDeletedException = new CourseNotEnrolledException(courseCode);
        try {
            AdminServiceInterface adminServiceInterface = new AdminService();
            boolean isDeleted = adminServiceInterface.deleteCourse(courseCode);
            if (isDeleted)
            	return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
            else
            	return Response.status(406).entity("Error while removing course from  : " + courseNotDeletedException.getMessage()).build();
        } catch (CourseNotEnrolledException ex){
        	return Response.status(409).entity(ex.getMessage()).build();
        }
	}
	
	/**
	 * 
	 * REST-service to approve a student by admin
	 * @param 
	 * @return 
	 */
	@PUT
	@Path("/approveStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveStudent(@NotNull @QueryParam("studentId") int studentId) {
		Student student = new StudentService().getStudentById(studentId);
		if (student == null) {
			return Response.status(404).entity("The Student with StudentID" +studentId + "Doesn't Exists").build();
        } else if (student.isApproved()) {
    		return Response.status(200).entity("Student Already Approved").build();

        } else {
            AdminServiceInterface adminServiceInterface = new AdminService();
            adminServiceInterface.approveStudent(student);
            return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();
        }
		
	}
	
	/**
	 * 
	 * REST-service to add professor by admin.
	 * @param professor
	 * @return 
	 */
	// Have not used @QueryParam here since professor has large no. of params
	// Instead we can accept the professor object reprs. as JSON.
	@POST
	@Path("/addProfessor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(@Valid Professor professor) {
		AdminServiceInterface adminServiceInterface = new AdminService();
		// add professor doesn't throws any exception, maybe we need to change it??
        boolean isAdded = adminServiceInterface.addProfessor(professor);
        if (isAdded)
        	return Response.status(201).entity("Professor with professorId: " + professor.getProfessorId() + " added").build();
        else
        	return Response.status(201).entity("Some Error Occoured, Try Again Later").build();
	}
	
	/**
	 * 
	 * REST-service to generate Grade Card
	 * @param studentId ??
	 * @return 
	 */
	@POST
	@Path("/generateReport")
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateReport(){
		// TODO , Yet to be implemented.
    	return Response.status(403).entity("FORBIDDEN").build();

	}
}
