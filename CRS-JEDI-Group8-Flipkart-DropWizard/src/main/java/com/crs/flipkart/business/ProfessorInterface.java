/**
 *
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.exceptions.*;

import java.util.List;

/**
 * @author adarsh
 *
 */
public interface ProfessorInterface {
	/**
	 * Method to add grade for student by the professor
	 * @param courseId
	 * @param studentId
	 * @param marks
	 * @return boolean
	 */
	public boolean addGrade(int courseId, int studentId, double marks) throws GradeNotAddedException, CourseNotFoundException, UserNotFoundException;

	/**
	 * Method to select a particular course  to teach for the  professor.
	 * @param courseId
	 * @param professorId
	 * @return
	 */
	public boolean selectCourseToTeach(int courseId, int professorId) throws CourseNotAssignedToProfessorException;

	/**
	 * Method to retrieve all the students enrolled for a particular course.  
	 * @param courseId
	 * @return List of Integer (studentId)
	 */
	public List<Integer> getStudentList(int courseId);

	/**
	 * Method to get all the courses for professor.
	 * @param
	 * @return List of Course 
	 */
	public List<Course> getCourseList();

	/**
	 * Method to view Students for all the courses
	 * @param professorId
	 * @return List of String.
	 */
	public List<String> viewStudentsForAllCourses(int professorId);

	/**
	 * Method to check Credentials of  Professor
	 * @param email
	 * @param password
	 * @return
	 */
	int checkCredentials(String email, String password) throws InvalidCredentialsException;

	/**
	 * Method to retrieve Professor by ID
	 * @param professorId
	 * @return
	 */
	public Professor getProfessorById(int professorId) throws ProfessorNotFoundException;

	public void updateCredentials(String email, String password);
}
