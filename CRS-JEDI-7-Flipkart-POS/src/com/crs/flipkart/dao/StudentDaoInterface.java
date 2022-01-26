package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

public interface StudentDaoInterface {
    public Student getStudentById(int studentId);
    public int checkCredentials(String email, String password);
    public Student saveStudent(Student student);
}
