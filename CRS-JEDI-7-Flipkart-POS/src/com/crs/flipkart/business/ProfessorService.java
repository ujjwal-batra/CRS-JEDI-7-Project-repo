package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.CourseOperationDAO;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorInterface {

    public boolean addGrade(int courseId, int studentId, double marks) {
        ProfessorDaoInterface professorDaoInterface = new ProfessorDAO();
        return professorDaoInterface.addGrade(studentId, courseId, marks);
    }

    public void selectCourseToTeach(int courseId, int professorId) {
        Course course = new CourseOperationDAO().getCourseById(courseId);
        course.setProfessorId(professorId);
        new CourseOperationDAO().updateCourse(course);
    }

    public List<Integer> getStudentList(int courseId) {
        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    }

    public List<Course> getCourseList() {
        return new CourseOperationDAO().getCourseCatalogue().getCourseList();
    }

    public void updateCredentials(String email, String password) {
        new ProfessorDAO().updateCredentials(email, password);
    }

    public List<String> viewStudentsForAllCourses(int professorId) {
        List<String> studentList = new ArrayList<>();
        StudentDao studentDao = new StudentDao();
        for (Course course : getCourseList()) {
            if (course.getProfessorId() != -1 && course.getProfessorId() == professorId) {
                List<Integer> studentListForSingleCourse = getStudentList(course.getCourseId());
                for (Integer studentId : studentListForSingleCourse) {
                    studentList.add("\nStudentID: " + studentId + ", StudentName: " + studentDao.getStudentById(studentId).getName() +
                            ", CourseID: " + course.getCourseId() + ", CourseName" + course.getCourseName());
                }

            }
        }
        return studentList;
    }
}
