/**
 * 
 */
package com.crs.flipkart.business;

/**
 * @author adarsh
 *
 */
public interface SemesterRegistrationInterface {
	/**
	 * Method to initiate semester registration for student
	 * @param studentId
	 * @param semesterId
	 * @return List of Integer (courseId)
	 */
	public boolean semesterRegistration(int studentId, int semesterId);
}
