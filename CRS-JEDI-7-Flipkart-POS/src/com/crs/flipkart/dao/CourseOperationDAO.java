package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;
import com.crs.flipkart.constants.SQLQueryConstants;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseOperationDAO implements CourseOperationDaoInterface {

    private static final Logger logger = LogManager.getLogger(CourseOperationDAO.class);

    /**
     * Method to get all courses  from the course catalogue
     *
     * @param
     * @return CourseCatalogue
     */
    @Override
    public CourseCatalogue getCourseCatalogue() {
        return new CourseCatalogue(1, "Catalogue", getAllCourses());
    }

    /**
     * Method to get list of  all courses
     *
     * @param
     * @return List of Course
     */
    @Override
    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = SQLQueryConstants.SELECT_ALL_COURSES;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name"),
                        resultSet.getInt("professor_id")
                );
                courseList.add(course);
            }
        } catch (Exception ex) {
            logger.error("Error while retrieving all courses: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                logger.error("Error: " + ex.getMessage());
            }
        }
        return courseList;
    }

    /**
     * Method to get course by  its ID
     *
     * @param courseId
     * @return Course
     */
    @Override
    public Course getCourseById(int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = SQLQueryConstants.SELECT_COURSE_BY_ID + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Course course = null;
            while (resultSet.next()) {
                course = new Course(
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name"),
                        resultSet.getInt("professor_id")
                );
            }
            return course;
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
     * Method to update course information
     *
     * @param course
     * @return
     */
    @Override
    public void updateCourse(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = SQLQueryConstants.ASSIGN_PROFESSOR_TO_COURSE +
                    course.getProfessorId() + " where course_id = " + course.getCourseId();
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate();

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
    }

    /**
     * Method to get the student count ina course.
     *
     * @param courseId
     * @return int
     */
    @Override
    public int getStudentCount(int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = SQLQueryConstants.GET_ENROLLED_STUDENT_COUNT + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            int studentCount = 0;
            while (resultSet.next()) {
                studentCount++;
            }
            return studentCount;
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

    /**
     * Method to get student list in a course
     *
     * @param courseId
     * @return List of Integer
     */
    @Override
    public List<Integer> getStudentListByCourseId(int courseId) {
        List<Integer> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = SQLQueryConstants.GET_STUDENT_LIST_BY_COURSE_ID + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                res.add(resultSet.getInt("student_id"));
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

    /**
     * Method to retrieve Grades of a student
     *
     * @param studentId
     * @return List of String
     */
    @Override
    public List<String> getGrades(int studentId) {
        List<String> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = SQLQueryConstants.VIEW_ENROLLED_COURSES + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int grade = resultSet.getInt("grade");
                res.add("\nCourse id: " + resultSet.getInt("course_id") +
                        ", Course Name: " + getCourseById(resultSet.getInt("course_id")).getCourseName() +
                        ", Grade: " + (grade == 0 ? "Grade not given yet" : grade)
                );

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
}
