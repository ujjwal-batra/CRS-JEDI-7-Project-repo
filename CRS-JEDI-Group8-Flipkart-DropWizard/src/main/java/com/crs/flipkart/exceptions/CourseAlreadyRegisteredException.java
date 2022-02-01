/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if the course is already registered.
 */
public class CourseAlreadyRegisteredException extends Exception {

	private int courseId;

	/***
	 * Constructor
	 * 
	 * @param courseId
	 */
	public CourseAlreadyRegisteredException(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "You have already registered for " + courseId;
	}

}
