/**
 *
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;

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
    public boolean addGrade(int courseId, int studentId, double marks);
    
    /**
	 * Method to select a particular course  to teach for the  professor.
	 * @param courseId
	 * @param professorId
	 * @return 
	 */
    public void selectCourseToTeach(int courseId, int professorId);
    
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
}
