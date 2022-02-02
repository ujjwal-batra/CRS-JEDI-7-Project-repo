package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

public interface AdminDaoInterface {
    /**
	 * Method to add course from the admin
	 * @param courseId
	 * @param courseName
	 * @return boolean
	 */
    public int addCourse(int courseId, String courseName);
    
    /**
	 * Method to delete course by the admin
	 * @param courseId
	 * @return boolean
	 */
    public int deleteCourse(int courseId);
    
    /**
	 * Method to check credentials of admin
	 * @param email
	 * @param password
	 * @return boolean
	 */
    public int checkCredentials(String email, String password);

    /**
	 * Method to approve a student from the admin
	 * @param student
	 * @return 
	 */
    public void approveStudent(Student student);
    
    /**
	 * Method to add professor by the admin
	 * @param professor
	 * @return boolean
	 */
    public boolean addProfessor(Professor professor);

    void updateCredentials(String email, String password);
}
