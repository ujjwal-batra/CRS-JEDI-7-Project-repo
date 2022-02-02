package com.crs.flipkart.exceptions;

/**
 * Exception to check if student has been allotted grade by professor
 * 
 * @author JEDI-02
 *
 */
public class GradeNotAddedException extends Exception {

	private int studentId;

	/**
	 * Constructor
	 * 
	 * @param studentId
	 */
	public GradeNotAddedException(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Message returned when exception is thrown
	 *
	 * @return string: error message
	 */
	@Override
	public String getMessage() {
		return "Grade not added for studentId: " + studentId + " because student has not registered for the course.";
	}

}