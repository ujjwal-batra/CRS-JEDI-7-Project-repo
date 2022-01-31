/**
 *
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.NotificationDao;
import com.crs.flipkart.dao.NotificationDaoInterface;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author JEDI-8
 *
 */
public class PaymentNotificationService implements PaymentNotificationInterface {

    private static final Logger logger = LogManager.getLogger(PaymentNotificationService.class);

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

        logger.info("Sending payment notification to student id: " + student.getStudentId() + ", payment id: " + payment_id);

        NotificationDaoInterface notificationDaoInterface = new NotificationDao();
        notificationDaoInterface.sendNotification(notification);
    }

    /**
     * Method to get last payment ID
     * notification
     * @return
     */
    public int getLastID(Notification notification) {
        NotificationDaoInterface notificationDaoInterface = new NotificationDao();
        return notificationDaoInterface.getLastID(notification);
    }

    @Override
    public List<String> getNotificationById(int studentId) {
        NotificationDaoInterface notificationDaoInterface = new NotificationDao();
        return notificationDaoInterface.getNotificationById(studentId);
    }
}
