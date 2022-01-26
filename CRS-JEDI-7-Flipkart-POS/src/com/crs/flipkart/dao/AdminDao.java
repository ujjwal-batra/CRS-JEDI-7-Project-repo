package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDao implements  AdminDaoInterface{
    public int checkCredentials(String email, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from admin where email = '" + email + "' and password = '" + password + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return -1;
            } else
                return resultSet.getInt("admin_id");
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
        return -1;
    }

    public void approveStudent(Student student){
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            // System.out.println("Checking Credentials");
            String sqlQuery = "update student SET is_approved = 1  WHERE student_id = " + student.getStudentId();
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);

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

    public boolean addCourse(int courseId, String courseName){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Integer nullObject = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Genetrating course");
            String sqlQuery = "insert into course values(?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, courseId);
            statement.setString(2, courseName);
            statement.setNull(3, nullObject);
            statement.executeUpdate(sqlQuery);
            return true;
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
        return false;
    }
}
