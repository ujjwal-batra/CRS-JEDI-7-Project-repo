/**
 * 
 */
package com.crs.flipkart.restController;

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

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.business.CourseOperationService;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;

/**
 * @author Adarsh
 *
 */

@Path("/admin")
public class AdminRestAPI {
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
	
	@GET
	@Path("/showCoursesCatalogue")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> showCourseCatalogue() {
		 List<Course> courseList = new CourseOperationService().getCourseCatalogue().getCourseList();
		 return courseList;
	}
	
	
	@PUT
	@Path("/deleteCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCourse(@NotNull
								 @QueryParam("courseCode") int courseCode) {
		CourseNotDeletedException courseNotDeletedException = new CourseNotDeletedException(courseCode);
        try {
            AdminServiceInterface adminServiceInterface = new AdminService();
            boolean isDeleted = adminServiceInterface.deleteCourse(courseCode);
            if (isDeleted)
            	return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
            else
            	return Response.status(406).entity("Error while removing course from  : " + courseNotDeletedException.getMessage()).build();
        } catch (CourseNotDeletedException ex){
        	return Response.status(409).entity(ex.getMessage()).build();
        }
	}
	
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
	
	// Will not use @QueryParam here since professor has large no. of params
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
	
	@POST
	@Path("/generateReport")
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateReport(){
		// TODO , Yet to be implemented.
    	return Response.status(403).entity("FORBIDDEN").build();

	}
}
