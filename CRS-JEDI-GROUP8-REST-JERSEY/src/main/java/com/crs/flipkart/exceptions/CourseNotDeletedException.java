/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if course was delted successfully.
 */
public class CourseNotDeletedException extends Exception {

	/*
	 * Course Code which cannot be Deleted.
	 */
	private int courseCode;

	public CourseNotDeletedException(int courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " can not be deleted.";
	}
}
