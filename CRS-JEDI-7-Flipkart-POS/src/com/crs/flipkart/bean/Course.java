/**
 *
 */
package com.crs.flipkart.bean;

import java.util.List;

/**
 * @author JEDI-8
 *
 */
public class Course {

    private int courseId;
    private String courseName;
    private Professor professor;
    private List<Student> studentList;

    public Course() {
    }

    public Course(int courseId, String courseName, Professor professor, List<Student> studentList) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professor = professor;
        this.studentList = studentList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
