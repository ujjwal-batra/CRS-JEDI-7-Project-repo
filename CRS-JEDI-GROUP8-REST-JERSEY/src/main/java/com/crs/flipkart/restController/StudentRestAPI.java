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
import com.crs.flipkart.exceptions.CourseAlreadyRegisteredException;
import com.crs.flipkart.exceptions.CourseNotEnrolledException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.CourseRegistrationAlreadyDone;
import com.crs.flipkart.exceptions.InvalidCredentialsException;
import com.crs.flipkart.exceptions.StudentAlreadyRegisteredForSemester;
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
		try {
			studentServiceInterface.semesterRegistration(student.getStudentId(), student.getSemester());
			
			return Response.status(201).entity("Semester Registration Complete").build();
			
		} catch(StudentAlreadyRegisteredForSemester ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		} catch(UserNotFoundException ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		}
	}
	
	@POST
	@Path("/saveStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response saveStudent(Student student) {
		System.out.println(student.toString());
		System.out.println("ujjwal");
		Student isSaved = studentServiceInterface.saveStudent(student);
		if(isSaved != null) {
			return Response.status(201).entity("Student Registration complete. Email -> " + isSaved.getEmailId()).build();
		}
		return Response.status(201).entity("Student can't be saved. Try again!!").build();
	}
	
	@POST
	@Path("/addCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addCourse(EnrolledCourse enrolledCourse) {
		try {
			int isAdded = studentServiceInterface.addCourse(enrolledCourse.getStudentId(), enrolledCourse.getCourseId());
			if(isAdded == -2) {
				return Response.status(201).entity("Alredy registed for 4 courses. Drop one to add another").build();
			}
			return Response.status(201).entity("Course added Succesfully").build();
		} catch(CourseAlreadyRegisteredException ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		} catch (CourseNotFoundException ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		}
	}
	
	@POST
	@Path("/dropCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response dropCourse(EnrolledCourse enrolledCourse) {
		try {
			boolean isDropped =  studentServiceInterface.dropCourse(enrolledCourse.getStudentId(), enrolledCourse.getCourseId());
			
			return Response.status(201).entity("Dropped successful").build();
		} catch(CourseNotFoundException ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		} catch(CourseNotEnrolledException ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		}
	}
	
	@POST
	@Path("/courseRegistration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response courseRegistration(CourseSelection courseSelection) {
		System.out.println();
		ArrayList<Integer> list;
		try {
			list = studentServiceInterface.courseRegistration(courseSelection.getStudentId(), courseSelection.getPrimary(), courseSelection.getSecondary());
			return Response.status(201).entity("successfully registered : "+ list.toString()).build();
		} catch (CourseRegistrationAlreadyDone ex) {
			return Response.status(201).entity(ex.getMessage()).build();
		}
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
