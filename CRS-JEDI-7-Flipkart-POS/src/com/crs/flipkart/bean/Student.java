/**
 *
 */
package com.crs.flipkart.bean;

import java.util.ArrayList;

/**
 * @author JEDI-8
 *
 */
public class Student extends User {

    private int studentId;
    private String branch;
    private boolean isApproved;
    private int semester;
    private GradeCard gradeCard;

    public Student() {
    }

    public Student(int studentId, String name, String password, String emailId, long contactNo, String userType, String address, String gender, String branch, boolean isApproved, int semester) {
        super(name, password, emailId, contactNo, userType, address, gender);
        this.studentId = studentId;
        this.branch = branch;
        this.isApproved = isApproved;
        this.semester = semester;
        this.gradeCard = new GradeCard(studentId, new ArrayList<>(), 0.0);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public GradeCard getGradeCard() {
        return gradeCard;
    }

    public void setGradeCard(GradeCard gradeCard) {
        this.gradeCard = gradeCard;
    }
}
