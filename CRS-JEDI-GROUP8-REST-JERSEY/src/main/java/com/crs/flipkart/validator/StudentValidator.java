/**
 * 
 */
package com.crs.flipkart.validator;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.exceptions.CourseNotFoundException;

/**
 * @author Adarsh
 *
 */
public class StudentValidator {

	/**
	 * Method to validate if student is already registered for this particular course (courseCode) or not 
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList  
	 * @return
	 * @throws CourseNotFoundException
	 */
	public static boolean isRegistered(int courseId,int studentId,List<Course>registeredCourseList) throws CourseNotFoundException
	{
		for(Course course : registeredCourseList)
		{
			if(courseId==course.getCourseId()) 
				return true; 
		}
		
		return false;
	}
	
	
	/**
	 * Method to validate if couseCode is valid or not
	 * @param courseCode
	 * @param availableCourseList
	 * @return
	 */
	public static boolean isValidCourseCode(int courseId,List<Course> availableCourseList) 
	{
		for(Course course : availableCourseList)
		{
			if(courseId==course.getCourseId()) 
				return true; 
		}
		
		return false;
	
	}


}
