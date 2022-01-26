package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

public interface AdminDaoInterface {
    public boolean addCourse(int courseId, String courseName);
    public boolean deleteCourse(int courseId);
    public int checkCredentials(String email, String password);
    public void approveStudent(Student student);
}
