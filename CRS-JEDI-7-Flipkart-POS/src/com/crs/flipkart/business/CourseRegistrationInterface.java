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
	public boolean addCourse(int studentId, int courseId, int semesterId);
	public boolean dropCourse(int studentId, int courseId, int semesterId);
	public List<Course> viewCourseList();
	public boolean registerCourse();
}
