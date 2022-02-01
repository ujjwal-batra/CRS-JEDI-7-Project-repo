package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;

import java.util.List;

public interface CourseOperationDaoInterface {
	/**
	 * Method to get all courses  from the course catalogue
	 * @param 
	 * @return CourseCatalogue
	 */
    public CourseCatalogue getCourseCatalogue();
    
    /**
	 * Method to get course by  its ID
	 * @param courseId
	 * @return Course
	 */
    public Course getCourseById(int courseId);
    
    /**
   	 * Method to update course information
   	 * @param course
   	 * @return
   	 */
    public boolean updateCourse(Course course);
    
    /**
   	 * Method to get list of  all courses
   	 * @param 
   	 * @return List of Course
   	 */
    public List<Course> getAllCourses();
    
    /**
   	 * Method to get the student count ina course.
   	 * @param courseId
   	 * @return int
   	 */
    public int getStudentCount(int courseId);
    
    /**
   	 * Method to get student list in a course
   	 * @param courseId
   	 * @return List of Integer
   	 */
    public List<Integer> getStudentListByCourseId(int courseId);
    
    /**
	 * Method to retrieve Grades of a student
	 * @param studentId
	 * @return List of String
	 */
    public List<String> getGrades(int studentId);
}
