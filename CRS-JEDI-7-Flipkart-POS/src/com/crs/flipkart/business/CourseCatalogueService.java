package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;

import java.util.List;

public class CourseCatalogueService {

    private List<Course> courseList;

    public List<Course> getCourses() {
        return courseList;
    }

    public void retrieveCoursesFromDB() {
        //DB code
        courseList.add(new Course(1, "DSA", null, null));
        courseList.add(new Course(2, "TOC", null, null));
    }
}
