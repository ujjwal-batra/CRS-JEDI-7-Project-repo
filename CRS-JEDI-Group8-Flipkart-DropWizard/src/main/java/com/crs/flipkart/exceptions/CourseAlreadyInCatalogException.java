/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author hp
 *
 */
public class CourseAlreadyInCatalogException extends Exception {
	private int courseCode;

	public CourseAlreadyInCatalogException(int courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Message returned when exception is thrown
	 */
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " Already in catalog.";
	}
}
