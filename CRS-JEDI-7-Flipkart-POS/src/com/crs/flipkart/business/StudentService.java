package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.CourseOperationDAO;
import com.crs.flipkart.dao.StudentDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentServiceInterface {

    private static final Logger logger = LogManager.getLogger(PaymentService.class);
    StudentDao studentDao = new StudentDao();
    CourseOperationDAO courseCatalogueDAO = new CourseOperationDAO();

    /**
     * Method to initiate semester registration for student
     *
     * @param studentId
     * @param semester
     * @return List of Integer (courseId)
     */

    @Override
    public boolean semesterRegistration(int studentId, int semester) {
        logger.debug("In instance of StudentService, registering semester student id: " + studentId + ", semester: " + semester);
        return new StudentDao().semesterRegistration(studentId, semester);
    }

    /**
     * Method to register for course
     *
     * @param studentId
     * @param primary
     * @param secondary
     * @return List of Integer (courseId)
     */

    @Override
    public ArrayList<Integer> courseRegistration(int studentId, int[] primary, int[] secondary) {
        int secondaryIndex = 0;
        ArrayList<Integer> registeredCourse = new ArrayList<>();
        for (int courseId : primary) {
            if (courseCatalogueDAO.getStudentCount(courseId) >= 10) {
                logger.info("Course id: " + courseId + " already contains 10 students, hence going with secondary course id: " + secondary[secondaryIndex]);
                studentDao.addCourse(studentId, secondary[secondaryIndex]);
                registeredCourse.add(secondary[secondaryIndex++]);
            } else {
                studentDao.addCourse(studentId, courseId);
                registeredCourse.add(courseId);
            }
        }
        return registeredCourse;
    }

    /**
     * Method remove course from database
     *
     * @param studentId
     * @param courseId
     * @return List of Integer (courseId)
     */

    @Override
    public boolean dropCourse(int studentId, int courseId) {
        logger.info("Dropping course with id: " + courseId);
        return studentDao.dropCourse(studentId, courseId);
    }

    /**
     * Method to add course to database
     *
     * @param studentId
     * @param courseId
     * @return List of Integer (courseId)
     */

    @Override
    public int addCourse(int studentId, int courseId) {
        List<Integer> enrolledCourses = studentDao.viewEnrolledCourse(studentId);
        if (enrolledCourses.size() == 4) {
            return -2;
        }
        if (enrolledCourses.contains(courseId)) {
            return -1;
        }
        return studentDao.addCourse(studentId, courseId) ? 1 : 0;
    }

    /**
     * Method to view all the registered courses
     *
     * @param studentId
     * @return List of Integer (courseId)
     */

    /**
     * Method to view all  the registered courses
     *
     * @param studentId
     * @return List of string
     */
    @Override
    public List<String> viewRegisteredCourse(int studentId) {
        List<Integer> enrolledCourses = studentDao.viewEnrolledCourse(studentId);
        List<String> result = new ArrayList<>();
        logger.debug("In instance of StudentService view registered courses.");
        enrolledCourses.forEach(enrolledCourseId -> {
            String courseName = courseCatalogueDAO.getCourseById(enrolledCourseId).getCourseName();
            result.add("\nCourseId: " + enrolledCourseId + ", Course name: " + courseName);
        });
        return result;
    }

    /**
     * Method to get last ID from database
     *
     * @param student
     * @return
     */
    @Override
    public void getLastId(Student student) {
        new StudentDao().getLastId(student);
    }

    /**
     * Method to save a student info to database
     *
     * @param student
     * @return Student
     */
    @Override
    public Student saveStudent(Student student) {
        return new StudentDao().saveStudent(student);
    }

    /**
     * Method to check login credentials of Student
     *
     * @param email
     * @param password
     * @return int
     */
    @Override
    public int checkCredentials(String email, String password) {
        return new StudentDao().checkCredentials(email, password);
    }

    /**
     * Method to retrieve Student info. from their ID
     *
     * @param studentId
     * @return Student
     */
    @Override
    public Student getStudentById(int studentId) {
        return new StudentDao().getStudentById(studentId);
    }

    /**
     * Method to retrieve Grade card
     *
     * @param studentId
     * @return List of String
     */
    @Override
    public List<String> getGradeCard(int studentId) {
        return new CourseOperationDAO().getGrades(studentId);
    }
}
