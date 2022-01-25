package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;

import java.util.List;

public interface CourseCatalogueDaoInterface {
    public CourseCatalogue getCourseCatalogue();
    public Course getCourseById(int courseId);
    public void updateCourse(Course course);
    public List<Course> getAllCourses();
}
