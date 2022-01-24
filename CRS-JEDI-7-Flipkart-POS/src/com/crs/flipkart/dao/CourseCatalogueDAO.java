package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseCatalogueDAO {

    private CourseCatalogue courseCatalogue;
    private List<Course> courseList = new ArrayList<>(Arrays.asList(
            new Course(1, "DSA", null, null),
            new Course(2, "TOC", null, null)

    ));

    public List<Course> getCourses() {
        return courseList;
    }

    public CourseCatalogue getCourseCatalogue() {
        return courseCatalogue;
    }

    public void setCourseCatalogue(CourseCatalogue courseCatalogue) {
        this.courseCatalogue = courseCatalogue;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
