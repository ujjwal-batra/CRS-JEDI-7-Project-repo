/**
 * 
 */
package com.crs.flipkart.validator;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;

/**
 * @author Adarsh
 *
 */
public class AdminValidator {
	
	/**
	 * Method to validate if newCourse is not already present in catalog
	 * @param newCourse
	 * @param courseList
	 * @return
	 */
	public static boolean isValidNewCourse(int courseId, List<Course> courseList) {
		
		for(Course course : courseList) {
			if(courseId==course.getCourseId()) {
				return false; 
			}
		}
		return true;
	}
	
	/**
	 * Method to validate if dropCourse is already present in catalog
	 * @param dropCourseCode
	 * @param courseList
	 * @return
	 */
	public static boolean isValidDropCourse(int dropCourseId, List<Course> courseList) {
		for(Course course : courseList) {
			if(dropCourseId==course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * Method to validate if studentId is still unapproved
	 * @param studentId
	 * @param studentList
	 * @return
	 */
	public static boolean isValidUnapprovedStudent(int studentId, List<Student> studentList) {
		for(Student student : studentList) {
			if(studentId == student.getStudentId() && student.isApproved()==false) {
				return true;
			}
		}
		return false;
	}
}
