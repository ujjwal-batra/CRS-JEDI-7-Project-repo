/**
 * 
 */
package com.crs.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.crs.flipkart.bean.CourseSelection;
import com.crs.flipkart.bean.EnrolledCourse;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.exceptions.InvalidCredentialsException;
import com.crs.flipkart.exceptions.UserNotApprovedExecption;
import com.crs.flipkart.exceptions.UserNotFoundException;

/**
 * @author ujjwal
 *
 */

@Path("/student")
public class StudentRestAPI {
	
	private static final Logger logger = LogManager.getLogger(StudentRestAPI.class);
	StudentServiceInterface studentServiceInterface = new StudentService();
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response studentLogin(Student student) {
		logger.info("Login request: " + student.getEmailId());
		try {
			int isLogged = studentServiceInterface.checkCredentials(student.getEmailId(), student.getPassword());
			int isApproved = studentServiceInterface.isApproved(isLogged);
			return Response.status(201).entity("Logged in successful").build();
		} catch(InvalidCredentialsException ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		} catch(UserNotApprovedExecption ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		}
	}
	
	@POST
	@Path("/semesterRegistration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response semesterRegistration(Student student) {
		
		boolean isRegistered = studentServiceInterface.semesterRegistration(student.getStudentId(), student.getSemester());
		if(isRegistered) {
			return Response.status(201).entity("Semester Registration Complete").build();
		}
		return Response.status(201).entity("Registration failed try again").build();
	}
	
	@POST
	@Path("/saveStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response saveStudent(Student student) {
		
		Student isSaved = studentServiceInterface.saveStudent(student);
		if(isSaved != null) {
			return Response.status(201).entity("Student Registration complete. Email -> " + isSaved.getStudentId()).build();
		}
		return Response.status(201).entity("Student can't be saved. Try again!!").build();
	}
	
	@POST
	@Path("/addCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addCourse(EnrolledCourse enrolledCourse) {
		int isAdded = studentServiceInterface.addCourse(enrolledCourse.getStudentId(), enrolledCourse.getCourseId());
		if(isAdded == -2) {
			return Response.status(201).entity("Alredy registed for 4 courses. Drop one to add another").build();
		}
		else if(isAdded == -1) {
			return Response.status(201).entity("Course with Course_id = "+ enrolledCourse.getCourseId() + " already added").build();
		}
		return Response.status(201).entity("Course added Succesfully").build();
	}
	
	@POST
	@Path("/dropCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response dropCourse(EnrolledCourse enrolledCourse) {
		System.out.println();
		boolean isDropped =  studentServiceInterface.dropCourse(enrolledCourse.getStudentId(), enrolledCourse.getCourseId());
		if(isDropped) {
			return Response.status(201).entity("Dropped successful").build();
		}
		return Response.status(201).entity("Cannot be dropped").build();
	}
	
	@POST
	@Path("/courseRegistration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response courseRegistration(CourseSelection courseSelection) {
		System.out.println();
		ArrayList<Integer> list =  studentServiceInterface.courseRegistration(courseSelection.getStudentId(), courseSelection.getPrimary(), courseSelection.getSecondary());
		System.out.println(list);
		return Response.status(201).entity("successfully registered : "+ list.toString()).build();
	}
	
	@GET
	@Path("/getStudentById/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getStudentById(@PathParam("studentId") int studentId) {
		Student student= studentServiceInterface.getStudentById(studentId);
		System.out.println(student);
		return Response.status(200).entity(student.getName()).build();
	}
	
	@GET
	@Path("/getGradeCard/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getGradeCard(@PathParam("studentId") int studentId) {
		List<String> res = studentServiceInterface.getGradeCard(studentId);
		System.out.println(res);
		return Response.status(200).entity(res.toString()).build();
	}
	
	@GET
	@Path("/viewRegisteredCourse/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response viewRegisteredCourse(@PathParam("studentId") int studentId) {
		List<String> res = studentServiceInterface.viewRegisteredCourse(studentId);
		System.out.println(res);
		return Response.status(200).entity(res.toString()).build();
	}
}
