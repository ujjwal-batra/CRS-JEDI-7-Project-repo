package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;
import com.crs.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseCatalogueDAO implements CourseCatalogueDaoInterface {

    @Override
    public CourseCatalogue getCourseCatalogue() {
        return new CourseCatalogue(1, "Catalogue", getAllCourses());
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from course";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name"),
                        resultSet.getInt("professor_id"),
                        new ArrayList<>()
                );
                courseList.add(course);
            }
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
        return courseList;
    }

    @Override
    public Course getCourseById(int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from course where course_id = " + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Course course = null;
            while (resultSet.next()) {
                course = new Course(
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name"),
                        resultSet.getInt("professor_id"),
                        new ArrayList<>()
                );
            }
            return course;
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
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "update course set professor_id = " +
                    course.getProfessorId() + " where course_id = " + course.getCourseId();
            statement = connection.prepareStatement(sqlQuery);
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
}
