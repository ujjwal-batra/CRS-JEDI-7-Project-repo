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
    private int professorId;
    private List<Student> studentList;

    public Course() {
    }

    public Course(int courseId, String courseName, int professorId, List<Student> studentList) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professorId = professorId;
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

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
