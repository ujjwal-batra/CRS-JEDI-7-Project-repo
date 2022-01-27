package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.CourseOperationDAO;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorInterface {
	
	/**
	 * Method to add grade for student by the professor
	 * @param courseId
	 * @param studentId
	 * @param marks
	 * @return boolean
	 */
    public boolean addGrade(int courseId, int studentId, double marks) {
        return new ProfessorDAO().addGrade(studentId, courseId, marks);
    }
    
    /**
	 * Method to select a particular course  to teach for the  professor.
	 * @param courseId
	 * @param professorId
	 * @return 
	 */
    public void selectCourseToTeach(int courseId, int professorId) {
        Course course = new CourseOperationDAO().getCourseById(courseId);
        course.setProfessorId(professorId);
        new CourseOperationDAO().updateCourse(course);
    }
    
    /**
   	 * Method to retrieve all the students enrolled for a particular course.  
   	 * @param courseId
   	 * @return List of Integer (studentId)
   	 */
    public List<Integer> getStudentList(int courseId) {
        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    }
    
    /**
	 * Method to get all the courses for professor.
	 * @param 
	 * @return List of Course 
	 */
    public List<Course> getCourseList() {
        return new CourseOperationDAO().getCourseCatalogue().getCourseList();
    }
    
    /**
	 * Method to update  the credentials of the professor
	 * @param email
	 * @param password
	 * @return  
	 */
    public void updateCredentials(String email, String password) {
        new ProfessorDAO().updateCredentials(email, password);
    }
    
    /**
	 * Method to view Students for all the courses
	 * @param professorId
	 * @return List of String.
	 */
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
