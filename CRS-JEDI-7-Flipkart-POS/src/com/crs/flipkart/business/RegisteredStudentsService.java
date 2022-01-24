package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.utils.GetInstance;

import java.util.ArrayList;
import java.util.List;

public class RegisteredStudentsService implements RegisteredStudentsInterface {

    public List<Student> getStudentListByCourseId(int courseId) {
        Course course = GetInstance.courseCatalogueDAO.getCourseById(courseId);
        return course.getStudentList();
    }

    public List<Course> getCourseListForStudentId(int studentId) {
        //retrieve list from db;
        return new ArrayList<>();
    }
}
