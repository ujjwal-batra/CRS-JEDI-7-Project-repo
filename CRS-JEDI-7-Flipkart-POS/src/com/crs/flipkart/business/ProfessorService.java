package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Grade;
import com.crs.flipkart.bean.Student;

import java.util.List;

public class ProfessorService {

    public void addGrade(int courseId, int studentId, Grade grade) {
        //save data inside db

    }

    public void selectCourseToTeach(int courseId, int professorId) {
        //save data inside db
    }

    public List<Student> viewStudentList(int courseId) {
        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    }

    public List<Course> viewCourseList() {
        return new CourseCatalogueService().getCourses();
    }
}
