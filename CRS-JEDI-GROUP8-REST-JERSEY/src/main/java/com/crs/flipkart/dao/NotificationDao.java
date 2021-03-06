package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.constants.Constants;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificationDao implements NotificationDaoInterface {

    private static final Logger logger = LogManager.getLogger(NotificationDao.class);

    @Override
    public void sendNotification(Notification notification) {
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
            logger.error("Error while sending notification: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
    }

    @Override
    public int getLastID(Notification notification) {
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
            return notification.getNotificationId();

        } catch (Exception ex) {
            logger.error("Error while retrieving notification: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return 1;
    }

    @Override
    public List<String> getNotificationById(int studentId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_ALL_NOTIFICATION_BY_ID + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<String> messageList = new ArrayList<String>();
            while (resultSet.next()) {
                messageList.add(resultSet.getString("message"));
            }
            return messageList;

        } catch (Exception ex) {
            logger.error("Error while retrieving notification: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return new ArrayList<>();
    }
}
