package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.Constants;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements StudentDaoInterface {

    private static final Logger logger = LogManager.getLogger(StudentDao.class);

    /**
     * Method to get lastId from the database
     *
     * @param student
     * @return
     */
    @Override
    public void getLastId(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_ALL_STUDENTS;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_id"));
            }


        } catch (Exception ex) {
            logger.error("Error while retrieving student: " + ex.getMessage());
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
     * Method to save student info to database
     *
     * @param student
     * @return Student
     */
    @Override
    public Student saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.ADD_STUDENT;
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getEmailId());
            statement.setString(4, student.getPassword());
            statement.setString(5, student.getBranch());
            statement.setInt(6, student.getSemester());
            statement.setBoolean(7, student.isApproved());
            statement.setString(8, student.getAddress());
            statement.setString(9, student.getGender());
            statement.setLong(10, student.getContactNo());

            statement.executeUpdate();

        } catch (Exception ex) {
            logger.error("Error while saving student: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return student;
    }

    /**
     * Method to retrieve student by their ID
     *
     * @param studentId
     * @return Student
     */
    @Override
    public Student getStudentById(int studentId) {
        Connection connection = null;
        PreparedStatement statement = null;
        Student student = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.SELECT_STUDENT_BY_ID + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setGender(resultSet.getString("gender"));
                student.setAddress(resultSet.getString("address"));
                student.setContactNo(resultSet.getLong("contact_number"));
                student.setApproved(resultSet.getBoolean("is_approved"));
                student.setPassword(resultSet.getString("password"));
                student.setName(resultSet.getString("name"));
                student.setBranch(resultSet.getString("branch"));
                student.setSemester(resultSet.getInt("semester"));
                student.setEmailId(resultSet.getString("email"));
            }
            return student;

        } catch (Exception ex) {
            logger.error("Error while retrieving student: " + ex.getMessage());
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
     * Method to check login credentials
     *
     * @param email
     * @param password
     * @return int
     */
    @Override
    public int checkCredentials(String email, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();

            String sqlQuery = Constants.CHECK_CREDENTIALS_STUDENT + email + "' and password = '" + password + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            System.out.println(resultSet.getFetchSize());
            if (!resultSet.next()) {
                return -1;
            } else
                return resultSet.getInt("student_id");
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
        return -1;
    }

    /**
     * Method to add semester registration info to the database
     *
     * @param studentId
     * @param semester
     * @return boolean
     */
    @Override
    public int semesterRegistration(int studentId, int semester) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();

            String sqlQuery = Constants.SELECT_STUDENT_BY_ID + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return -2;
            }

            sqlQuery = Constants.SELECT_STUDENT_BY_ID + studentId + " and semester = -1";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet1 = statement.executeQuery(sqlQuery);
            if (!resultSet1.next()) {
                return -1;
            }

            sqlQuery = Constants.SET_STUDENT_SEMESTER + semester + " where student_id = " + studentId;
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate();
            return 1;
        } catch (Exception ex) {
            logger.error("Error during semester registration: " + ex.getMessage());
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

    /**
     * Method to add course to the database
     *
     * @param studentId
     * @param courseId
     * @return boolean
     */
    @Override
    public boolean addCourse(int studentId, int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from course where course_id = " + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if (!resultSet.next()) {
                return false;
            }

            sqlQuery = Constants.STUDENT_ENROLL_COURSE;
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, courseId);
            statement.setInt(2, studentId);
            statement.setNull(3, Types.INTEGER);
            statement.executeUpdate();
            return true;
        } catch (Exception ex) {
            logger.error("Error while adding course: " + ex.getMessage());
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
     * Method to remove course from the database
     *
     * @param studentId
     * @param courseId
     * @return boolean
     */
    @Override
    public int dropCourse(int studentId, int courseId) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            statement = connection.createStatement();

            String sqlQuery = "select * from course where course_id = " + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if (!resultSet.next()) {
                return -1;
            }

            sqlQuery = "select * from enrolled_course where student_id = " + studentId + " and course_id = " + courseId;
            ResultSet resultSet1 = statement.executeQuery(sqlQuery);

            if (!resultSet1.next()) {
                return -2;
            }

            sqlQuery = Constants.STUDENT_DROP_COURSE + studentId
                    + " and course_id = " + courseId;
            statement.executeUpdate(sqlQuery);
            return 1;
        } catch (Exception ex) {
            logger.error("Error while dropping course: " + ex.getMessage());
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

    /**
     * Method to view all enrolled courses ofa student
     *
     * @param studentId
     * @return List of Integer
     */
    @Override
    public List<Integer> viewEnrolledCourse(int studentId) {
        List<Integer> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.VIEW_ENROLLED_COURSES + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                res.add(resultSet.getInt("course_id"));
            }
            return res;
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
        return res;
    }

    @Override
    public int ifCourseRegistred(int studentId, int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = Constants.CHECK_IF_COURSE_REGISTERED;
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            System.out.println(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                return 1;
            } else
                return 0;
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
        return 0;
    }

    public void updateCredentials(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from student where email = '" + email + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return;
            }
            sqlQuery = Constants.UPDATE_STUDENT_PASSWORD + "'" + password + "'" + " where email = '" + email + "'";
            int isUpdated = statement.executeUpdate(sqlQuery);
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

    public int isApproved(int studentId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from student where student_id = " + studentId + " and is_approved = 1";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                return 1;
            }
            return 0;
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
        return 0;
    }
}
