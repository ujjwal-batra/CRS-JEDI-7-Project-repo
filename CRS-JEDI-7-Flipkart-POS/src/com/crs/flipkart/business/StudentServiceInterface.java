package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentServiceInterface {
	/**
	 * Method initiate semester Registration
	 * @param student
	 * @param semester
	 * @return List of Integer (courseId)
	 */
    boolean semesterRegistration(int studentId, int semester);
    
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
	 */
    int addCourse(int studentId, int courseId);
    
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
	 */
    int checkCredentials(String email, String password);
    
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
}
