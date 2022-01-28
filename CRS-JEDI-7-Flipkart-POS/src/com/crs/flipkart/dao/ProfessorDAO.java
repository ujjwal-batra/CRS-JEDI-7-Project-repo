package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.constants.Constants;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProfessorDAO implements ProfessorDaoInterface {

    private static final Logger logger = LogManager.getLogger(ProfessorDAO.class);

    /**
     * Method to save professor information to database
     *
     * @param professor
     * @return
     */
    @Override
    public void saveProfessor(Professor professor) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
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

        } catch (Exception ex) {
            logger.error("Error while saveProfessor: " + ex.getMessage());
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
     * Method to Professor information from database.
     *
     * @param professorId
     * @return Professor
     */
    @Override
    public Professor getProfessorById(int professorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_PROFESSOR_BY_ID + professorId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Professor professor = null;
            while (resultSet.next()) {
                professor = new Professor(
                        resultSet.getInt("professor_id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("contact_number"),
                        "Professor",
                        resultSet.getString("address"),
                        resultSet.getString("gender"),
                        resultSet.getString("department"),
                        new ArrayList<>()
                );
            }
            if (professor != null) populateCourses(professor);
            return professor;
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
        return null;
    }

    /**
     * Method to populate courses  ofprofessor
     *
     * @param professor
     * @return
     */
    @Override
    public void populateCourses(Professor professor) {
        List<Course> courseList = new CourseOperationDAO().getAllCourses();
        for (Course course : courseList) {
            if (course.getProfessorId() == professor.getProfessorId())
                professor.getCourseList().add(course);
        }
        return;
    }

    /**
     * Method to check login credentials of professor.
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public int checkCredentials(String email, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.CHECK_CREDENTIALS_PROFESSOR + email + "' and password = '" + password + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return -1;
            } else
                return resultSet.getInt("professor_id");
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
     * Method to update login credentials of professor.
     *
     * @param email
     * @param password
     * @return boolean
     */
    @Override
    public boolean updateCredentials(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_PROFESSOR_BY_EMAIL + email;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return false;
            }
            sqlQuery = Constants.UPDATE_PROFESSOR_PASSWORD + password + " where email = " + email;
            ResultSet resultSet1 = statement.executeQuery(sqlQuery);
            if (!resultSet1.next())
                return false;
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
        return true;
    }

    /**
     * Method to add grades for courses by the  professor
     *
     * @param studentId
     * @param courseId
     * @param marks
     * @return boolean
     */
    @Override
    public boolean addGrade(int studentId, int courseId, double marks) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.ADD_GRADE_BY_PROFESSOR + ((int) marks)
                    + " where student_id = " + studentId + " and course_id = " + courseId;
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate();
            return true;
        } catch (Exception ex) {
            logger.error("Error while adding grades: " + ex.getMessage());
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

}
