package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

public interface AdminDaoInterface {
    public int checkCredentials(String email, String password);
    public void approveStudent(Student student);
}
