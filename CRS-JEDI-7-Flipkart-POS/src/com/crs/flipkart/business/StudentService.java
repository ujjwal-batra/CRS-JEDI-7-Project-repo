package com.crs.flipkart.business;

import com.crs.flipkart.dao.CourseCatalogueDAO;
import com.crs.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();
    CourseCatalogueDAO courseCatalogueDAO = new CourseCatalogueDAO();

    public boolean semesterRegistration(int studentId, int semester) {
        return new StudentDao().semesterRegistration(studentId, semester);
    }

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

    public boolean dropCourse(int studentId, int courseId) {
        return studentDao.dropCourse(studentId, courseId);
    }

    public boolean addCourse(int studentId, int courseId) {
        return studentDao.addCourse(studentId, courseId);
    }

    public List<String> viewRegisteredCourse(int studentId) {
        List<Integer> enrolledCourses = studentDao.viewEnrolledCourse(studentId);
        List<String> result = new ArrayList<>();

        for (Integer enrolledCourseId : enrolledCourses) {
            String courseName = courseCatalogueDAO.getCourseById(enrolledCourseId).getCourseName();
            result.add(courseName);
        }
        return result;
    }
}
