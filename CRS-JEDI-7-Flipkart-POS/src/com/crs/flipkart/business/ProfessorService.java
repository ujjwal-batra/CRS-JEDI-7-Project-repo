package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Grade;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.CourseCatalogueDAO;
import com.crs.flipkart.dao.ProfessorDAO;

import java.util.List;

public class ProfessorService {

    public void addGrade(int courseId, Student student, int semester, double marks) {
        Grade gradeObj = new Grade(courseId, student.getStudentId(), semester, marks);
        List<Grade> gradeList = student.getGradeCard().getGrades();
        gradeList.add(gradeObj);
    }

    public void selectCourseToTeach(int courseId, int professorId) {
        Professor professor = new ProfessorDAO().getProfessorById(professorId);
        Course course = new CourseCatalogueDAO().getCourseById(courseId);
        course.setProfessor(professor);
        professor.getCourseList().add(course);
    }

    public List<Student> viewStudentList(int courseId) {
        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    }

    public List<Course> viewCourseList() {
        return new CourseCatalogueDAO().getCourses();
    }
}
