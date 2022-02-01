/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author hp
 *
 */
public class StudentAlreadyRegisteredForSemester extends Exception {
	private int userId;

	/***
	 * Constructor function for UserId
	 * 
	 * @param userId
	 */

	public StudentAlreadyRegisteredForSemester(int userId) {
		super();
		this.userId = userId;
	}

	@Override
	public String getMessage() {
		return "This User " + userId + " is already registered for semester";
	}
}
