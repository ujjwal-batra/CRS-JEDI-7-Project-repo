package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.CourseAlreadyRegisteredException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.InvalidCredentialsException;
import com.crs.flipkart.exceptions.StudentAlreadyRegisteredForSemester;
import com.crs.flipkart.exceptions.UserNotApprovedExecption;
import com.crs.flipkart.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface StudentServiceInterface {
	/**
	 * Method initiate semester Registration
	 * @param student
	 * @param semester
	 * @return List of Integer (courseId)
	 * @throws StudentAlreadyRegisteredForSemester 
	 * @throws UserNotFoundException 
	 */
    boolean semesterRegistration(int studentId, int semester) throws StudentAlreadyRegisteredForSemester, UserNotFoundException;
    
    /**
	 * Method to initiate course Registration
	 * @param studentId
	 * @param primary
	 * @param secondary
	 * @return ArrayList of Integer (courseId)
	 */
    ArrayList<Integer> courseRegistration(int studentId, int[] primary, int[] secondary);
    
    /**
	 * Method to remove a course
	 * @param studentId
	 * @param courseId
	 * @return boolean
	 */
    boolean dropCourse(int studentId, int courseId);
    
    /**
	 * Method to add a course
	 * @param studentId
	 * @param courseId
	 * @return int
     * @throws CourseNotFoundException 
     * @throws CourseAlreadyRegisteredException 
	 */
    int addCourse(int studentId, int courseId) throws CourseAlreadyRegisteredException, CourseNotFoundException;
    
    /**
	 * Method to view all  the registered courses
	 * @param studentId
	 * @return List of string
	 */
    List<String> viewRegisteredCourse(int studentId);
    
    /**
	 * Method to get last ID from database
	 * @param student
	 * @return 
	 */
    void getLastId(Student student);
    
    /**
	 * Method to save a student info to database
	 * @param student
	 * @return Student
	 */
    Student saveStudent(Student student);
    
    /**
	 * Method to check login credentials of Student
	 * @param email
	 * @param password
	 * @return int
     * @throws InvalidCredentialsException 
	 */
    int checkCredentials(String email, String password) throws InvalidCredentialsException;
    
    /**
	 * Method to retrieve Student info. from their ID
	 * @param studentId
	 * @return Student
	 */
    Student getStudentById(int studentId);
    
    /**
	 * Method to retrieve Grade card 
	 * @param studentId
	 * @return List of String
	 */
    List<String> getGradeCard(int studentId);

    public int ifCourseRegistered(int studentId, int courseId) throws CourseAlreadyRegisteredException;

	public void updateCredentials(String email, String password);
	
	public int isApproved(int studentId) throws UserNotApprovedExecption;
}
