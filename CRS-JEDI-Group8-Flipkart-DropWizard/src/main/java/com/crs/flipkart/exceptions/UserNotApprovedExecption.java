/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if the user is approved.
 */

public class UserNotApprovedExecption extends Exception {
	private int userId;

	/***
	 * Constructor function for UserId
	 * 
	 * @param userId
	 */

	public UserNotApprovedExecption(int userId) {
		super();
		this.userId = userId;
	}

	@Override
	public String getMessage() {
		return "This User " + userId + " is not approved";
	}

}
