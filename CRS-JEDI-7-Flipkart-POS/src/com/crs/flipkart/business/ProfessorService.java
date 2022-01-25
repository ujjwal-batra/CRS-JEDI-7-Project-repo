package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Grade;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.CourseCatalogueDAO;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorInterface {

    public void addGrade(int courseId, int studentId, int semester, double marks) {
        Student student = new StudentDao().getStudentById(studentId);
        Grade gradeObj = new Grade(courseId, student.getStudentId(), semester, marks);
        List<Grade> gradeList = student.getGradeCard().getGrades();
        gradeList.add(gradeObj);
    }

    public void selectCourseToTeach(int courseId, int professorId) {
        Professor professor = new ProfessorDAO().getProfessorById(professorId);
        Course course = new CourseCatalogueDAO().getCourseById(courseId);
        course.setProfessor(professor);
        new CourseCatalogueDAO().updateCourse(course);
    }

    public List<Student> getStudentList(int courseId) {
        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    }

    public List<Course> getCourseList() {
        return new CourseCatalogueDAO().getCourseCatalogue().getCourseList();
    }

    public List<Student> viewStudentsForAllCourses(int professorId) {
        List<Student> studentList = new ArrayList<>();

        for (Course course : getCourseList()) {
            if (course.getProfessor() != null && course.getProfessor().getProfessorId() == professorId)
                studentList.addAll(getStudentList(course.getCourseId()));
        }

        return studentList;
    }
}
