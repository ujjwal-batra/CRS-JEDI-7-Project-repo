package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;

public interface ProfessorDaoInterface {
	/**
   	 * Method to save professor information to database
   	 * @param professor
   	 * @return 
   	 */
    public void saveProfessor(Professor professor);
    
    /**
   	 * Method to Professor information from database.
   	 * @param professorId
   	 * @return Professor
   	 */
    public Professor getProfessorById(int professorId);
    
    /**
   	 * Method to check login credentials of professor.
   	 * @param email
   	 * @param password
   	 * @return 
   	 */
    public int checkCredentials(String email, String password);
    
    /**
   	 * Method to update login credentials of professor.
   	 * @param email
   	 * @param password
   	 * @return boolean
   	 */
    public boolean updateCredentials(String email, String password);
    
    /**
   	 * Method to populate courses  ofprofessor
   	 * @param professor
   	 * @return 
   	 */
    public void populateCourses(Professor professor);
    
    /**
   	 * Method to add grades for courses by the  professor
   	 * @param studentId
   	 * @param courseId
   	 * @param marks
   	 * @return boolean 
   	 */
    public boolean addGrade(int studentId, int courseId, double marks);
}
