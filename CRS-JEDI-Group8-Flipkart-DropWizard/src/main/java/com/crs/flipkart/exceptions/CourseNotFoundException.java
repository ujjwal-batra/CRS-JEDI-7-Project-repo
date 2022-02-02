/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if course exists.
 */
public class CourseNotFoundException extends Exception {

	// Course Code which cannot be found.
	private int courseCode;

	public CourseNotFoundException(int courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " not found.";
	}

}
