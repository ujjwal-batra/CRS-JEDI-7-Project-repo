package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

public interface StudentDaoInterface {
    public void registerCourse();
    public Student getStudentById(int studentId);
}
