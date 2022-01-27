/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;

/**
 * @author adarsh
 *
 */
public interface RegisteredStudentsInterface {
	/**
	 * Method to get all the students enrolled in a course
	 * @param courseId
	 * @return List of Integer (StudentId)
	 */
	public List<Integer> getStudentListByCourseId(int courseId);
	/**
	 * Method to get all the courses taken by a student
	 * @param studentId
	 * @return List of Integer (courseId)
	 */
	public List<Course> getCourseListForStudentId(int studentId);
	
}
