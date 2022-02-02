/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if the user exists in the system.
 */

public class UserNotFoundException extends Exception {
	private int userId;

	/***
	 * Constructor function for UserId
	 * 
	 * @param userId
	 */
	public UserNotFoundException(int userId) {
		super();
		this.userId = userId;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "User with userId: " + userId + " does not exist";
	}

}
