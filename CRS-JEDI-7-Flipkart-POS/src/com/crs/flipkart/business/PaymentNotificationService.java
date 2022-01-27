/**
 *
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.Constants;
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
	 * @param Student
	 * @param payment
	 * @return 
	 */
    public void sendNotification(Student student, Payment payment) {
        Notification notification = new Notification();
        getLastID(notification);
        notification.setStudentId(student.getStudentId());
        notification.setNotificationType("Payment notification");
        notification.setMessage("Your payment is successful with PaymentID:" + String.valueOf(payment.getPaymentId()));

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.ADD_NOTIFICATION;
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, notification.getNotificationId());
            statement.setInt(2, notification.getStudentId());
            statement.setString(3, notification.getMessage());
            statement.setString(4, notification.getNotificationType());

            statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    /**
	 * Method to get last payment ID
	 * @param Student
	 * @param payment
	 * @return 
	 */
    public void getLastID(Notification notification){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_ALL_NOTIFICATION;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                notification.setNotificationId(resultSet.getInt("notification_id"));
            }


        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }

}
