/**
 *
 */
package com.crs.flipkart.bean;

/**
 * @author JEDI-8
 *
 */
public class Grade {
    private int courseId;
    private int studentId;
    private int semester;
    private double marks;

    public Grade(int courseId, int studentId, int semester, double marks) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.semester = semester;
        this.marks = marks;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
