package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.CourseOperationDAO;

import java.util.List;

public class CourseRegistrationService implements CourseRegistrationInterface {
	
	/**
	 * Method to add a course and save it to the db
	 * @param studentId
	 * @param courseId
	 * @param semesterId
	 * @return boolean
	 */
    public boolean addCourse(int studentId, int courseId, int semesterId) {
        //Save data inside the db
        //Check enrolledStudent < 10

        return true;        //status
    }
    
    /**
	 * Method to drop a course and remvoe it from the db
	 * @param studentId
	 * @param courseId
	 * @param semesterId
	 * @return boolean
	 */
    public boolean dropCourse(int studentId, int courseId, int semesterId) {
        //Save data inside the db;

        return true;        //status
    }
    
    /**
	 * Method to see all the course
	 * @param None
	 * @return List of Course
	 */
    public List<Course> viewCourseList() {
        return new CourseOperationDAO().getCourseCatalogue().getCourseList();
    }
    
    /**
	 * Method to register a particular course
	 * @param None
	 * @return boolean
	 */
    public boolean registerCourse() {
        return true;        //status
    }

}
