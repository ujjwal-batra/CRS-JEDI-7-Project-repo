package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;

import java.util.List;

public class CourseCatalogueDAO {

    private List<Course> courseList;

    public List<Course> getCourses() {
        return courseList;
    }

    public void createDummyData() {
        //DB code
        courseList.add(new Course(1, "DSA", null, null));
        courseList.add(new Course(2, "TOC", null, null));
    }

    public Course getCourseById(int courseId) {
        for (Course course : courseList) {
            if (course.getCourseId() == courseId) return course;
        }
        return null;
    }
}
