package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.utils.GetInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao {

    private List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "stud1", "root", "stud1@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(2, "stud2", "root", "stud2@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(3, "stud3", "root", "stud3@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(4, "stud4", "root", "stud4@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(5, "stud5", "root", "stud5@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(6, "stud6", "root", "stud6@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(7, "stud7", "root", "stud7@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2)
            )

    );

    public StudentDao() {
        registerCourse();
    }

    public void saveStudent(Student student) {

    }

    public void registerCourse() {
        GetInstance.courseCatalogueDAO.getCourseById(1).getStudentList().add(studentList.get(0));
        GetInstance.courseCatalogueDAO.getCourseById(1).getStudentList().add(studentList.get(1));
        GetInstance.courseCatalogueDAO.getCourseById(1).getStudentList().add(studentList.get(2));

        GetInstance.courseCatalogueDAO.getCourseById(2).getStudentList().add(studentList.get(3));
        GetInstance.courseCatalogueDAO.getCourseById(2).getStudentList().add(studentList.get(4));
        GetInstance.courseCatalogueDAO.getCourseById(2).getStudentList().add(studentList.get(5));
    }


    public Student getStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) return student;
        }
        return null;
    }

}
