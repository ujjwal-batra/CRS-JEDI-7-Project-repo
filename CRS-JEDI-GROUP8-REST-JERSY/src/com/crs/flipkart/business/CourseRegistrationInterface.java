/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;

/**
 * @author adarsh
 *
 */
public interface CourseRegistrationInterface {
	/**
	 * Method to add a course and save it to the db
	 * @param studentId
	 * @param courseId
	 * @param semesterId
	 * @return boolean
	 */
	public boolean addCourse(int studentId, int courseId, int semesterId);
	/**
	 * Method to drop a course and remvoe it from the db
	 * @param studentId
	 * @param courseId
	 * @param semesterId
	 * @return boolean
	 */
	public boolean dropCourse(int studentId, int courseId, int semesterId);
	/**
	 * Method to see all the course
	 * @param None
	 * @return List of Course
	 */
	public List<Course> viewCourseList();
	/**
	 * Method to register a particular course
	 * @param None
	 * @return boolean
	 */
	public boolean registerCourse();
}
