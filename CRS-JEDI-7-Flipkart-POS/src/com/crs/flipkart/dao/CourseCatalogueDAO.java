package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseCatalogueDAO {

    private final CourseCatalogue courseCatalogue;
    private final List<Course> courseList = new ArrayList<>(Arrays.asList(
            new Course(1, "DSA", null, new ArrayList<>()),
            new Course(2, "TOC", null, new ArrayList<>()),
            new Course(3, "ML", null, new ArrayList<>())

    ));

    public CourseCatalogueDAO() {
        courseCatalogue = new CourseCatalogue(1, "Catalogue", courseList);
    }

    public CourseCatalogue getCourseCatalogue() {
        return courseCatalogue;
    }

    public Course getCourseById(int courseId) {
        for (Course course : courseList) {
            if (course.getCourseId() == courseId) return course;
        }
        return null;
    }
}
