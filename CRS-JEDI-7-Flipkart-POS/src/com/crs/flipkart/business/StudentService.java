package com.crs.flipkart.business;

import com.crs.flipkart.dao.CourseOperationDAO;
import com.crs.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();
    CourseOperationDAO courseCatalogueDAO = new CourseOperationDAO();
    
    /**
	 * Method to initiate semester registration for student
	 * @param studentId
	 * @param semester
	 * @return List of Integer (courseId)
	 */
    public boolean semesterRegistration(int studentId, int semester) {
        return new StudentDao().semesterRegistration(studentId, semester);
    }
    
    /**
	 * Method to register for course
	 * @param studentId
	 * @param primary
	 * @param secondary
	 * @return List of Integer (courseId)
	 */
    public ArrayList<Integer> courseRegistration(int studentId, int[] primary, int[] secondary) {
        int secondaryIndex = 0;
        ArrayList<Integer> registeredCourse = new ArrayList<>();
        for (int courseId : primary) {
            if (courseCatalogueDAO.getStudentCount(courseId) >= 10) {
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
	 * @param studentId
	 * @param courseId
	 * @return List of Integer (courseId)
	 */
    public boolean dropCourse(int studentId, int courseId) {
        return studentDao.dropCourse(studentId, courseId);
    }
    
    /**
	 * Method to add course to database
	 * @param studentId
	 * @param courseId
	 * @return List of Integer (courseId)
	 */
    public int addCourse(int studentId, int courseId) {
        List<Integer> enrolledCourses = studentDao.viewEnrolledCourse(studentId);
        if (enrolledCourses.size() == 4) return -2;
        if (enrolledCourses.contains(courseId)) return -1;
        return studentDao.addCourse(studentId, courseId) ? 1 : 0;
    }
    
    /**
	 * Method to view all the registered courses
	 * @param studentId
	 * @return List of Integer (courseId)
	 */
    public List<String> viewRegisteredCourse(int studentId) {
        List<Integer> enrolledCourses = studentDao.viewEnrolledCourse(studentId);
        List<String> result = new ArrayList<>();

        for (Integer enrolledCourseId : enrolledCourses) {
            String courseName = courseCatalogueDAO.getCourseById(enrolledCourseId).getCourseName();
            result.add("\nCourseId: " + enrolledCourseId + ", Course name: " + courseName);
        }
        return result;
    }

}
