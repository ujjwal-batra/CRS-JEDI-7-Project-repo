/**
 *
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class Student extends User {

    private int studentId;
    private String branch;
    private boolean isApproved;
    private int semester;

    public Student() {
    }

    public Student(String userId, String name, String password, String emailId, long contactNo, String userType, String address, String gender, int studentId, String branch, boolean isApproved, int semester) {
        super(userId, name, password, emailId, contactNo, userType, address, gender);
        this.studentId = studentId;
        this.branch = branch;
        this.isApproved = isApproved;
        this.semester = semester;
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
}
