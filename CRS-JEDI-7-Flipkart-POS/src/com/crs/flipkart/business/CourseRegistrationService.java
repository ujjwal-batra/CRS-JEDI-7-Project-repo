package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.CourseCatalogueDAO;

import java.util.List;

public class CourseRegistrationService implements CourseRegistrationInterface {

    public boolean addCourse(int studentId, int courseId, int semesterId) {
        //Save data inside the db
        //Check enrolledStudent < 10

        return true;        //status
    }

    public boolean dropCourse(int studentId, int courseId, int semesterId) {
        //Save data inside the db;

        return true;        //status
    }

    public List<Course> viewCourseList() {
        return new CourseCatalogueDAO().getCourseCatalogue().getCourseList();
    }

    public boolean registerCourse() {
        return true;        //status
    }

}
