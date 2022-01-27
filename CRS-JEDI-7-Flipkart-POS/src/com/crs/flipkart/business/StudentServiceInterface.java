package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentServiceInterface {

    boolean semesterRegistration(int studentId, int semester);

    ArrayList<Integer> courseRegistration(int studentId, int[] primary, int[] secondary);

    boolean dropCourse(int studentId, int courseId);

    int addCourse(int studentId, int courseId);

    List<String> viewRegisteredCourse(int studentId);

    void getLastId(Student student);

    Student saveStudent(Student student);

    int checkCredentials(String email, String password);

    Student getStudentById(int studentId);

    List<String> getGradeCard(int studentId);
}
