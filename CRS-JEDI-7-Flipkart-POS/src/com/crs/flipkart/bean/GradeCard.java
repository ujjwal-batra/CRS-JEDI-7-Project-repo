/**
 *
 */
package com.crs.flipkart.bean;

import java.util.List;

/**
 * @author JEDI-8
 *
 */
public class GradeCard {

    private int studentId;
    private List<Grade> grades;
    private double sgpa;



    public GradeCard(int studentId, List<Grade> grades, double sgpa) {
        this.studentId = studentId;
        this.grades = grades;
        this.sgpa = sgpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public double getSgpa() {
        return sgpa;
    }

    public void setSgpa(double sgpa) {
        this.sgpa = sgpa;
    }
}
