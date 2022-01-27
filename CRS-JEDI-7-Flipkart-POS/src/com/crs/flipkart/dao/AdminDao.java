package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.utils.DBUtils;

import java.sql.*;

public class AdminDao implements AdminDaoInterface {

    @Override
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

    @Override
    public void approveStudent(Student student) {
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

    @Override
    public boolean addCourse(int courseId, String courseName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Genetrating course");
            String sqlQuery = "insert into course values(?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, courseId);
            statement.setString(2, courseName);
            statement.setNull(3, Types.INTEGER);

            statement.executeUpdate();
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

    @Override
    public boolean deleteCourse(int courseId) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("removing course...");
            String sqlQuery = "delete from course where course_id =" + courseId;
            statement = connection.createStatement();
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

    @Override
    public boolean addProfessor(Professor professor) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Adding professor...");
            String sqlQuery = "insert into professor values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, professor.getProfessorId());
            statement.setString(2, professor.getName());
            statement.setString(3, professor.getEmailId());
            statement.setString(4, professor.getPassword());
            statement.setLong(5, professor.getContactNo());
            statement.setString(6, professor.getAddress());
            statement.setString(7, professor.getGender());
            statement.setString(8, professor.getDepartment());

            statement.executeUpdate();
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
