package com.crs.flipkart.business;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseAlreadyInCatalogException;
import com.crs.flipkart.exceptions.CourseNotEnrolledException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.InvalidCredentialsException;

public interface AdminServiceInterface {
    /**
     * Method to add a course by the admin
     *
     * @param courseId
     * @param courseName
     * @return boolean
     * @throws CourseAlreadyInCatalogException 
     */
    public boolean addCourse(int courseId, String CourseName) throws AddCourseException, CourseAlreadyInCatalogException;

    /**
     * Method to delete a course by the admin
     *
     * @param courseId
     * @return boolean
     * @throws CourseNotFoundException 
     */
    public boolean deleteCourse(int courseId) throws  CourseNotFoundException;

    /**
     * Method to check credentials of admin
     *
     * @param email
     * @param password
     * @return int
     * @throws InvalidCredentialsException 
     */
    public int checkCredentials(String email, String password) throws InvalidCredentialsException;

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

    public void updateCredentials(String email, String password);
}
