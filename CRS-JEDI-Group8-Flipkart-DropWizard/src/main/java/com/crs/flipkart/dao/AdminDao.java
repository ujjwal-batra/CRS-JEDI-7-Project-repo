package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.Constants;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.*;

public class AdminDao implements AdminDaoInterface {

    private static final Logger logger = Logger.getLogger(AdminDao.class);

    /**
     * Method to check credentials of admin
     *
     * @param email
     * @param password
     * @return boolean
     */
    @Override
    public int checkCredentials(String email, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
        	System.out.println(email);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_ADMIN_BY_EMAIL + email + "' and password = '" + password + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            System.out.println(resultSet);
            if (!resultSet.next()) {
                return -1;
            } else {
                logger.info("Admin logged in. admin_id -> " + resultSet.getInt("admin_id"));
                return resultSet.getInt("admin_id");
            }
        } catch (Exception ex) {
            logger.error("Error while checking credentials: " + ex.getMessage());
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
     * Method to approve a student from the admin
     *
     * @param student
     * @return
     */
    @Override
    public void approveStudent(Student student) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.APPROVE_STUDENT + student.getStudentId();
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            logger.info("student Approved successfully");
        } catch (Exception ex) {
            logger.error("Error while approving student: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
    }

    /**
     * Method to add course from the admin
     *
     * @param courseId
     * @param courseName
     * @return boolean
     */
    @Override
    public boolean addCourse(int courseId, String courseName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Generating course");
            String sqlQuery = Constants.ADD_NEW_COURSE;
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, courseId);
            statement.setString(2, courseName);
            statement.setNull(3, Types.INTEGER);

            logger.info("In instance of Admin DAO, adding course with course id: " + courseId + " and course name: " + courseName);
            statement.executeUpdate();
            return true;
        } catch (Exception ex) {
            logger.error("Error while persisting course in db: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return false;
    }

    /**
     * Method to delete course by the admin
     *
     * @param courseId
     * @return boolean
     */
    @Override
    public boolean deleteCourse(int courseId) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("removing course...");

            String sqlQuery = Constants.DELETE_COURSE + courseId;
            statement = connection.createStatement();
            return statement.executeUpdate(sqlQuery) == 1;

        } catch (Exception ex) {
            logger.error("Error: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return false;
    }

    /**
     * Method to add professor by the admin
     *
     * @param professor
     * @return boolean
     */
    @Override
    public boolean addProfessor(Professor professor) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Adding professor...");
            String sqlQuery = Constants.ADD_PROFESSOR;
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
            logger.error("Error: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return false;
    }

    public void updateCredentials(String email, String password){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from admin where email = '" + email + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return;
            }
            sqlQuery = Constants.UPDATE_ADMIN_PASSWORD + "'" +password+ "'"+ " where email = '" + email + "'";
            statement.executeUpdate(sqlQuery);
            return;
        } catch (Exception ex) {
            logger.error("Error: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return;
    }
}
