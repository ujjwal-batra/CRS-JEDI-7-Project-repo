package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.CourseOperationDAO;

import java.util.ArrayList;
import java.util.List;

public class RegisteredStudentsService implements RegisteredStudentsInterface {

    public List<Integer> getStudentListByCourseId(int courseId) {
        return new CourseOperationDAO().getStudentListByCourseId(courseId);
    }

    public List<Course> getCourseListForStudentId(int studentId) {
        //retrieve list from db;
        return new ArrayList<>();
    }
}
