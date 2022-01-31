package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.CourseOperationDAO;

import java.util.ArrayList;
import java.util.List;

public class RegisteredStudentsService implements RegisteredStudentsInterface {
	/**
	 * Method to get all the students enrolled in a course
	 * @param courseId
	 * @return List of Integer (StudentId)
	 */
    public List<Integer> getStudentListByCourseId(int courseId) {
        return new CourseOperationDAO().getStudentListByCourseId(courseId);
    }
    /**
	 * Method to get all the courses taken by a student
	 * @param studentId
	 * @return List of Integer (courseId)
	 */
    public List<Course> getCourseListForStudentId(int studentId) {
        //retrieve list from db;
        return new ArrayList<>();
    }
}
