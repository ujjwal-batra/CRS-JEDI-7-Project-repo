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
public interface ProfessorInterface {
	public void addGrade(int courseId, int studentId, int semester, double marks);
	public void selectCourseToTeach(int courseId, int professorId);
	public List<Student> getStudentList(int courseId);
	public List<Course> getCourseList();
	public List<Student> viewStudentsForAllCourses(int professorId);
}
