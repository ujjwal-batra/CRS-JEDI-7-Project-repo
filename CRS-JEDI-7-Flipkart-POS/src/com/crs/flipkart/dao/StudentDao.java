package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

import java.util.List;

public class StudentDao {

    private List<Student> studentList;

    public void saveStudent(Student student) {
        studentList.add(student);
    }


}
