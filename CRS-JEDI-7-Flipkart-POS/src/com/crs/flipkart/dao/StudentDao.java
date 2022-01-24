package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

import java.util.List;

public class StudentDao {

    private List<Student> studentList;

    public void saveStudent(Student student) {
        studentList.add(student);
    }

    public void createDummy() {
    	studentList.add(new Student("1", "stud1", "root", "stud1@gmail.com", 78945612, "Student", "Delhi", "male", 1, "CSE", true, 2));
    	studentList.add(new Student("2", "stud2", "root", "stud2@gmail.com", 78945612, "Student", "Delhi", "male", 2, "CSE", true, 2));
    	studentList.add(new Student("3", "stud3", "root", "stud3@gmail.com", 78945612, "Student", "Delhi", "male", 3, "CSE", true, 2));
    	studentList.add(new Student("4", "stud4", "root", "stud4@gmail.com", 78945612, "Student", "Delhi", "male", 4, "CSE", true, 2));
    	studentList.add(new Student("5", "stud5", "root", "stud5@gmail.com", 78945612, "Student", "Delhi", "male", 5, "CSE", true, 2));
    	studentList.add(new Student("6", "stud6", "root", "stud6@gmail.com", 78945612, "Student", "Delhi", "male", 6, "CSE", true, 2));
    	studentList.add(new Student("7", "stud7", "root", "stud7@gmail.com", 78945612, "Student", "Delhi", "male", 7, "CSE", true, 2));
    }
}
