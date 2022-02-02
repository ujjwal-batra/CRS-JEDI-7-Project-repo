/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if course was delted successfully.
 */
public class CourseNotEnrolledException extends Exception {

	/*
	 * Course Code which cannot be Deleted.
	 */
	private int courseCode;

	public CourseNotEnrolledException(int courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + "  is not enrolled.";
	}
}
