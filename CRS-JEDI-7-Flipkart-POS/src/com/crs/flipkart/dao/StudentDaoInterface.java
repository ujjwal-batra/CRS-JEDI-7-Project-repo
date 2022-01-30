package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

import java.util.List;

public interface StudentDaoInterface {
	 /**
   	 * Method to retrieve student by their ID
   	 * @param studentId
   	 * @return Student
   	 */
    public Student getStudentById(int studentId);
   
    /**
   	 * Method to check login credentials 
   	 * @param email
   	 * @param password
   	 * @return int
   	 */
    public int checkCredentials(String email, String password);
    
    /**
   	 * Method to save student info to database
   	 * @param student
   	 * @return Student
   	 */
    public Student saveStudent(Student student);
    
    /**
   	 * Method to get lastId from the database
   	 * @param student
   	 * @return 
   	 */
    public void getLastId(Student student);
    
    /**
   	 * Method to add semester registration info to the database
   	 * @param studentId
   	 * @param semester
   	 * @return boolean
   	 */
    public boolean semesterRegistration(int studentId, int semester);
    
    /**
   	 * Method to add course to the database
   	 * @param studentId
   	 * @param courseId
   	 * @return boolean
   	 */
    public boolean addCourse(int studentId, int courseId);
    
    /**
   	 * Method to remove course from the database
   	 * @param studentId
   	 * @param courseId
   	 * @return boolean
   	 */
    public boolean dropCourse(int studentId, int courseId);
    
    /**
   	 * Method to view all enrolled courses ofa student
   	 * @param studentId
   	 * @return  List of Integer
   	 */
    public List<Integer> viewEnrolledCourse(int studentId);

    public int ifCourseRegistred(int studentId, int courseId);
}
