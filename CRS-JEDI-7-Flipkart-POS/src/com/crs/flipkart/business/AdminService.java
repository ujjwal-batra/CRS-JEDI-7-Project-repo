package com.crs.flipkart.business;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDao;
import com.crs.flipkart.dao.AdminDaoInterface;

public class AdminService implements AdminServiceInterface{
	
	/**
	 * Method to add a course by the admin
	 * @param courseId
	 * @param courseName
	 * @return boolean
	 */
    @Override
    public boolean addCourse(int courseId, String courseName) {
        if(courseId < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.addCourse(courseId, courseName);
    }
    
    /**
   	 * Method to delete a course by the admin
   	 * @param courseId
   	 * @return boolean
   	 */
    @Override
    public boolean deleteCourse(int courseId) {
        if(courseId < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.deleteCourse(courseId);
    }
    
    /**
   	 * Method to check credentials of admin
   	 * @param email
   	 * @param password
   	 * @return int
   	 */
    @Override
    public int checkCredentials(String email, String password) {
        if(email == "")
            return -1;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.checkCredentials(email, password);
    }
    
    /**
  	 * Method to approve a student by admin
  	 * @param student
  	 * @return 
  	 */
    @Override
	public void approveStudent(Student student) {
	    AdminDaoInterface adminDaoInterface = new AdminDao();
	      adminDaoInterface.approveStudent(student);
	  }
      /**
  	 * Method to add a professor to the system by the admin
  	 * @param professor
  	 * @return 
  	 */
    @Override
    public boolean addProfessor(Professor professor) {
        if(professor.getProfessorId() < 0)
            return false;
        AdminDaoInterface adminDaoInterface = new AdminDao();
        return adminDaoInterface.addProfessor(professor);
    }
    
  
}
