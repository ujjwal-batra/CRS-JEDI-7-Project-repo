/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if the course was assigned to professor.
 */
public class CourseNotAssignedToProfessorException extends Exception {

	/*
	 * @courseCode is not assigned to professor with @professorId.
	 */
	private int courseCode;
	private int professorId;

	public CourseNotAssignedToProfessorException(int courseCode, int professorId) {
		this.courseCode = courseCode;
		this.professorId = professorId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "courseCode: " + courseCode + " OR professorId: " + professorId + " does not exist!";
	}
}
