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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseNotEnrolledException;
import com.crs.flipkart.exceptions.InvalidCredentialsException;


/**
 * @author Adarsh
 *
 */

@Path("/admin")
public class AdminRestAPI {
	private static final Logger logger = LogManager.getLogger(AdminRestAPI.class);
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
    	if(response!=-1) {
    		logger.info("Login successful");
        	return Response.status(200).entity("Success").build();
    	}
        
    	else {
        	logger.error("Login unsuccessful");
        	return Response.status(200).entity("Invalid credentials").build();
        }
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
     	 logger.info("Course adding operation successful");
		 return Response.status(201).entity("Course with courseID: " + courseId + " added to catalog").build();
		 
		}
		catch(AddCourseException ex) {
        	logger.error("Course adding operation Unsuccessful");
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
		 logger.info("Course catalouge shown!");

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
		
            AdminServiceInterface adminServiceInterface = new AdminService();
            boolean isDeleted;
			try {
				isDeleted = adminServiceInterface.deleteCourse(courseCode);
			} catch (CourseNotEnrolledException e) {
            	return Response.status(201).entity("Exception occoured: " + e.getMessage()).build();

			}
            if (isDeleted) {
            	logger.info("Course successfully deleted");
            	return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
            }
            else {
            	logger.error("Course not deleted");
            	return Response.status(406).entity("Error while removing course " ).build();
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
	
	@POST
	@Path("/addProfessor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(@Valid Professor professor) {
		AdminServiceInterface adminServiceInterface = new AdminService();
		
        boolean isAdded = adminServiceInterface.addProfessor(professor);
        if (isAdded)
        	return Response.status(201).entity("Professor with professorId: " + professor.getProfessorId() + " added").build();
        else
        	return Response.status(201).entity("Some Error Occoured, Try Again Later").build();
	}
	
	/**
	 * 
	 * REST-service to generate Grade Card
	 * @param studentId 
	 * @return 
	 */
	@GET
	@Path("/generateReport/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response generateReport(@PathParam("studentId") int studentId){
		
		StudentServiceInterface studentService = new StudentService();
		List<String> grades = studentService.getGradeCard(studentId);
		//for(String xx : grades) System.out.println(xx);
		return Response.status(200).entity(grades.toString()).build();


	}
    	
}
