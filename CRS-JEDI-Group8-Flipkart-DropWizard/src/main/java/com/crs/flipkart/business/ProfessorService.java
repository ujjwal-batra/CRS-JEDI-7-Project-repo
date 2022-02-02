package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.CourseOperationDAO;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.StudentDao;
import com.crs.flipkart.exceptions.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorInterface {

    private static final Logger logger = LogManager.getLogger(ProfessorService.class);

    /**
     * Method to add grade for student by the professor
     *
     * @param courseId
     * @param studentId
     * @param marks
     * @return boolean
     */
    public boolean addGrade(int courseId, int studentId, double marks) throws GradeNotAddedException, CourseNotFoundException, UserNotFoundException {
        logger.info("Professor adding grade for student id: " + studentId + ", course id: " + courseId + ", marks" + marks);

        ProfessorDaoInterface professorDaoInterface = new ProfessorDAO();
        Course course = new CourseOperationDAO().getCourseById(courseId);
        Student student = new StudentDao().getStudentById(studentId);
        if (course == null)
            throw new CourseNotFoundException(courseId);
        if (student == null)
            throw new UserNotFoundException(studentId);

        boolean added = professorDaoInterface.addGrade(studentId, courseId, marks);
        if (!added) throw new GradeNotAddedException(studentId);
        return true;
    }

    /**
     * Method to select a particular course  to teach for the  professor.
     *
     * @param courseId
     * @param professorId
     * @return
     */
    public boolean selectCourseToTeach(int courseId, int professorId) throws CourseNotAssignedToProfessorException {
        Course course = new CourseOperationDAO().getCourseById(courseId);
        course.setProfessorId(professorId);
        logger.debug("Professor: " + professorId + " selecting course: " + courseId + " to teach");
        boolean added = new CourseOperationDAO().updateCourse(course);
        if (!added) throw new CourseNotAssignedToProfessorException(courseId, professorId);
        return true;
    }

    /**
     * Method to retrieve all the students enrolled for a particular course.
     *
     * @param courseId
     * @return List of Integer (studentId)
     */
    public List<Integer> getStudentList(int courseId) {
        logger.info("Retrieving StudentList for courseId: " + courseId);
        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    }

    /**
     * Method to get all the courses for professor.
     *
     * @param
     * @return List of Course
     */
    public List<Course> getCourseList() {
        logger.info("Retrieving course list for professor");
        return new CourseOperationDAO().getCourseCatalogue().getCourseList();
    }

    /**
     * Method to update  the credentials of the professor
     *
     * @param email
     * @param password
     * @return
     */
    public void updateCredentials(String email, String password) {
        logger.debug("In instance of Professor service updating credentials");
        new ProfessorDAO().updateCredentials(email, password);
    }

    /**
     * Method to view Students for all the courses
     *
     * @param professorId
     * @return List of String.
     */
    public List<String> viewStudentsForAllCourses(int professorId) {
        logger.debug("In instance of professor service, view all enrolled students");
        List<String> studentList = new ArrayList<>();
        StudentDao studentDao = new StudentDao();

        getCourseList().forEach(course -> {
            if (course.getProfessorId() != -1 && course.getProfessorId() == professorId) {
                List<Integer> studentListForSingleCourse = getStudentList(course.getCourseId());
                studentListForSingleCourse.forEach(studentId -> {
                    studentList.add("StudentID: " + studentId + ", StudentName: " + studentDao.getStudentById(studentId).getName() +
                            ", CourseID: " + course.getCourseId() + ", CourseName" + course.getCourseName());
                });
            }
        });
        return studentList;
    }

    /**
     * Method to check Credentials of  Professor
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public int checkCredentials(String email, String password) throws InvalidCredentialsException {
        logger.info("Checking credentials for emailId: " + email);
        int found = new ProfessorDAO().checkCredentials(email, password);
        if (found == -1) throw new InvalidCredentialsException();
        return found;
    }

    /**
     * Method to get professor by id
     *
     * @param professorId
     * @return
     * @throws ProfessorNotFoundException
     */
    @Override
    public Professor getProfessorById(int professorId) throws ProfessorNotFoundException {
        Professor professor = new ProfessorDAO().getProfessorById(professorId);
        if (professor == null) throw new ProfessorNotFoundException(professorId);
        return professor;
    }
}
