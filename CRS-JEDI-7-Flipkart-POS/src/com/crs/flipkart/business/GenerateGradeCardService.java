package com.crs.flipkart.business;

import com.crs.flipkart.bean.Grade;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.utils.GetInstance;

public class GenerateGradeCardService implements GenerateGradeCardInterface {

    public void generateGradeCard(int studentId) {
        Student student = GetInstance.studentDao.getStudentById(studentId);
        GradeCard gradeCard = student.getGradeCard();
        double totalMarks = 0.0;
        int totalCourses = 0;
        for (Grade grade : gradeCard.getGrades()) {
            totalMarks += grade.getMarks();
            totalCourses++;
        }
        gradeCard.setSgpa(totalMarks / totalCourses);
    }
}
