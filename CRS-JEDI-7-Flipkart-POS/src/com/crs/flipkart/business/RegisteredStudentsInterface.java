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
	public List<Integer> getStudentListByCourseId(int courseId);
	public List<Course> getCourseListForStudentId(int studentId);
	
}
