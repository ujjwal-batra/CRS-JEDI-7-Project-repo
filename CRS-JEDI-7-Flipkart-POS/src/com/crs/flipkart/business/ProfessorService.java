package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.dao.CourseOperationDAO;
import com.crs.flipkart.dao.ProfessorDAO;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.StudentDao;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.validator.ProfessorValidator;

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
    public boolean addGrade(int courseId, int studentId, double marks) {
        ProfessorDaoInterface professorDaoInterface = new ProfessorDAO();
        try {
	    	CourseOperationService courseCatalog = new CourseOperationService();
	        boolean validCourse = ProfessorValidator.isValidCourse(courseCatalog.getCourseCatalogue().getCourseList(),courseId);
	        if(!validCourse) throw new CourseNotFoundException(String.valueOf(courseId));
	        
	        boolean validStudent = ProfessorValidator.isValidStudent(new RegisteredStudentsService().getStudentListByCourseId(courseId),studentId);
	        if(!validStudent) throw new Exception();
        }
        catch (CourseNotFoundException ex) {
        	logger.error("The requested course was not found");
        }
        catch(Exception ex) {
        	logger.error("Student is not  registered for the course");
        }
        logger.info("Professor adding grade for student id: " + studentId + ", course id: " + courseId + ", marks" + marks);
        return professorDaoInterface.addGrade(studentId, courseId, marks);
    }

    /**
     * Method to select a particular course  to teach for the  professor.
     *
     * @param courseId
     * @param professorId
     * @return
     */
    public void selectCourseToTeach(int courseId, int professorId) {
        Course course = new CourseOperationDAO().getCourseById(courseId);
        course.setProfessorId(professorId);
        logger.debug("Professor: " + professorId + " selecting course: " + courseId + " to teach");
        new CourseOperationDAO().updateCourse(course);
    }

    /**
     * Method to retrieve all the students enrolled for a particular course.
     *
     * @param courseId
     * @return List of Integer (studentId)
     */
    public List<Integer> getStudentList(int courseId) {
    	try {
	    	CourseOperationService courseCatalog = new CourseOperationService();
	        boolean valid = ProfessorValidator.isValidCourse(courseCatalog.getCourseCatalogue().getCourseList(),courseId);
	        if(!valid) throw new CourseNotFoundException(String.valueOf(courseId));
	        logger.info("Retrieving StudentList for courseId: " + courseId);
	        return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    	}
    	catch(CourseNotFoundException ex) {
    		logger.error("The requested courseId doesn't exists");
    		return new RegisteredStudentsService().getStudentListByCourseId(courseId);
    	}
    }

    /**
     * Method to get all the courses for professor.
     *
     * @param
     * @return List of Course
     */
    public List<Course> getCourseList() {
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
                    studentList.add("\nStudentID: " + studentId + ", StudentName: " + studentDao.getStudentById(studentId).getName() +
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
    public int checkCredentials(String email, String password) {
        return new ProfessorDAO().checkCredentials(email, password);
    }

    /**
     * Method to get all the courses taken by a student
     *
     * @param studentId
     * @return List of Integer (courseId)
     */
    @Override
    public Professor getProfessorById(int professorId) {
        return new ProfessorDAO().getProfessorById(professorId);
    }
}
