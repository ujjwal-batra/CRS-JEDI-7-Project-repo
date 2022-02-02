/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author hp
 *
 */
public class CourseRegistrationAlreadyDone extends Exception {
	private int studentId;

	public CourseRegistrationAlreadyDone(int studentId) {
		this.studentId = studentId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	public String getMessage() {
		return "Student_id: " + studentId + " already Registered Registered. Please use add and drop to change course selection";
	}
}
