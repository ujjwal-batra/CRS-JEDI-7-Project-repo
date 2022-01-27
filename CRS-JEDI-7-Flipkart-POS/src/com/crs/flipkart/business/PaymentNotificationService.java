/**
 *
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.Constants;
import com.crs.flipkart.dao.NotificationDao;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author JEDI-8
 *
 */
public class PaymentNotificationService implements PaymentNotificationInterface {
	
	/**
	 * Method to send payment notifications after successful semester registration
	 * @param student
	 * @param payment_id
	 * @return 
	 */
    public void sendNotification(Student student, int payment_id) {
        Notification notification = new Notification();
        int notification_id = getLastID(notification) + 1;
        System.out.println(notification_id);
        notification.setNotificationId(notification_id);
        notification.setStudentId(student.getStudentId());
        notification.setNotificationType("Payment notification");
        notification.setMessage("Your payment is successful with PaymentID:" + payment_id);

        NotificationDaoInterface notificationDaoInterface = new NotificationDao();
        notificationDaoInterface.sendNotification(notification);
    }
    
    /**
	 * Method to get last payment ID
     * notification
	 * @return 
	 */
    public int getLastID(Notification notification){
        NotificationDaoInterface notificationDaoInterface = new NotificationDao();
        return notificationDaoInterface.getLastID(notification);
    }

}
