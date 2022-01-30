package com.crs.flipkart.business;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;

public interface AdminServiceInterface {
    /**
     * Method to add a course by the admin
     *
     * @param courseId
     * @param courseName
     * @return boolean
     */
    public boolean addCourse(int courseId, String CourseName) throws AddCourseException;

    /**
     * Method to delete a course by the admin
     *
     * @param courseId
     * @return boolean
     */
    public boolean deleteCourse(int courseId) throws CourseNotDeletedException;

    /**
     * Method to check credentials of admin
     *
     * @param email
     * @param password
     * @return int
     */
    public int checkCredentials(String email, String password);

    /**
     * Method to approve a student by admin
     *
     * @param student
     * @return
     */
    public void approveStudent(Student student);

    /**
     * Method to add a professor to the system by the admin
     *
     * @param professor
     * @return
     */
    public boolean addProfessor(Professor professor);
}
