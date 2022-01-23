package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;

import java.util.List;

public class CourseRegistrationService {

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
        return new CourseCatalogueService().getCourses();
    }

    public boolean registerCourse() {
        return true;        //status
    }

}
