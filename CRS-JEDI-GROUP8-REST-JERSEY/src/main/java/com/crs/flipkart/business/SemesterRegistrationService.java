/**
 *
 */
package com.crs.flipkart.business;

/**
 * @author JEDI-8
 *
 */
public class SemesterRegistrationService implements SemesterRegistrationInterface {
	
	/**
	 * Method to initiate semester registration for student
	 * @param studentId
	 * @param semesterId
	 * @return List of Integer (courseId)
	 */
    public boolean semesterRegistration(int studentId, int semesterId) {
        //save data inside the DB
        return true;
    }


}
