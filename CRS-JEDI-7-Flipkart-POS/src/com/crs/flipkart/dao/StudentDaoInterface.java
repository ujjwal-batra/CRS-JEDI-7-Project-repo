package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

import java.util.List;

public interface StudentDaoInterface {
    public Student getStudentById(int studentId);
    public int checkCredentials(String email, String password);
    public Student saveStudent(Student student);
    public void getLastId(Student student);
    public boolean semesterRegistration(int studentId, int semester);
    public boolean addCourse(int studentId, int courseId);
    public boolean dropCourse(int studentId, int courseId);
    public List<Integer> viewEnrolledCourse(int studentId);
}
