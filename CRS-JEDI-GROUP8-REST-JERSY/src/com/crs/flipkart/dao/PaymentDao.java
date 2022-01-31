package com.crs.flipkart.dao;

import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDao implements PaymentDaoInterface {

    private static final Logger logger = LogManager.getLogger(PaymentDao.class);

    /**
     * Method to insert payment info to the Database
     *
     * @param payment_id
     * @param invoice
     * @param studentId
     * @param amount
     * @param status
     * @param mode
     * @return
     */
    @Override
    public int makePayment(int payment_id, int invoice, int studentId, int amount, String status, String mode) {


        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "insert into payment values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, payment_id);
            statement.setInt(2, invoice);
            statement.setInt(3, studentId);
            statement.setInt(4, amount);
            statement.setString(5, status);
            statement.setString(6, mode);

            statement.executeUpdate();
            return payment_id;
        } catch (Exception ex) {
            logger.error("Error while making payment: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return -1;
    }

    /**
     * Method to send payment notifications to student
     *
     * @param
     * @return
     */
    @Override
    public void sendPaymentNotification() {

    }
}
