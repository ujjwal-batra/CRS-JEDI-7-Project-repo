/**
 * 
 */
package com.crs.flipkart.bean;

import java.util.List;

/**
 * @author JEDI-8
 *
 */
public class Professor extends User{

    private int professorId;
    private String department;
    private List<Course> courseList;

    public Professor() {
    }

    public Professor(int professorId, String name, String password, String emailId, long contactNo, String userType, String address, String gender, String department, List<Course> courseList) {
        super(name, password, emailId, contactNo, userType, address, gender);
        this.professorId = professorId;
        this.department = department;
        this.courseList = courseList;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
