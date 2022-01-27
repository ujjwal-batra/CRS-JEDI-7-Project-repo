/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.Student;

/**
 * @author adarsh
 *
 */
public interface PaymentNotificationInterface {
	/**
	 * Method to send payment notifications after successful semester registration
	 * @param Student
	 * @param payment
	 * @return 
	 */
	public void sendNotification(Student student, Payment payment);
}
