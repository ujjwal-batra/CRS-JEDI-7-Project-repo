package com.crs.flipkart.business;

import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.StudentDao;

public class GenerateGradeCardService implements GenerateGradeCardInterface {

    /**
     * Method to generate the grade card for  student
     *
     * @param studentId
     * @return
     */
    public void generateGradeCard(int studentId) {
        Student student = new StudentDao().getStudentById(studentId);
        GradeCard gradeCard = student.getGradeCard();
        final double[] totalMarks = {0.0};
        final int[] totalCourses = {0};
        gradeCard.getGrades().forEach(grade -> {
            totalMarks[0] += grade.getMarks();
            totalCourses[0]++;
        });
        gradeCard.setSgpa(totalMarks[0] / totalCourses[0]);
    }
}
