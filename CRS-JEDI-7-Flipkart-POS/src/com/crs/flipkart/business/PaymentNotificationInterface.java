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
	public void sendNotification(Student student, Payment payment);
}
