package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;

import java.util.List;

public interface CourseOperationDaoInterface {
    public CourseCatalogue getCourseCatalogue();

    public Course getCourseById(int courseId);

    public void updateCourse(Course course);

    public List<Course> getAllCourses();

    public int getStudentCount(int courseId);

    public List<Integer> getStudentListByCourseId(int courseId);

    List<String> getGrades(int studentId);
}
