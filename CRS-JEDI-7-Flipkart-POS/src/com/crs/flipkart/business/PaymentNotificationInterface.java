/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.Student;

/**
 * @author adarsh
 *
 */
public interface PaymentNotificationInterface {
	/**
	 * Method to send payment notifications after successful semester registration
	 * @param student
	 * @param payment_id
	 * @return 
	 */
	public void sendNotification(Student student, int payment_id);

	/**
	 * get last id of notification
	 * notification
	 * @return
	 */
	public int getLastID(Notification notification);
}
