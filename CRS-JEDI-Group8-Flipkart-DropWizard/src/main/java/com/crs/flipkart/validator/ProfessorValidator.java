/**
 * 
 */
package com.crs.flipkart.validator;
import java.util.List;

import com.crs.flipkart.bean.*;
/**
 * @author Adarsh
 *
 */
public class ProfessorValidator {
	/**
	 * Method to check if Student exist in the database
	 * @param students: list of students in the database
	 * @param studentId: current student
	 * @return true, if student is valid. else, false.
	 */
	public static boolean isValidStudent(List<Integer> students,int studentId) {
		
		boolean result=false;
		
		for(int i=0;i<students.size();i++) {
			
			if(students.get(i)==studentId)
				result=true;
				
		}
		return result;
	}
	
	/**
	 * Method to check if course exist in the database
	 * @param courses: list of courses assigned to the professor
	 * @param courseId: course id for which grade needs to be added
	 * @return true, if course is valid and taught by professor, else false.
	 */
	public static boolean isValidCourse(List<Course> assignedCourses,int courseId)
	{
		//check if course is valid
		boolean result=false;
		
		for(int i=0;i<assignedCourses.size();i++) {
			if(assignedCourses.get(i).getCourseId()==(courseId))
				result= true;
		}
		return result;
	}
}
