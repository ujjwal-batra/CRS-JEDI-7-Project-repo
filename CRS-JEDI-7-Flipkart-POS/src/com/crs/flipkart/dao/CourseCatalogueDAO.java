package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalogue;
import com.crs.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseCatalogueDAO implements CourseCatalogueDaoInterface {

    private final CourseCatalogue courseCatalogue;
    private final List<Course> courseList = new ArrayList<>(Arrays.asList(
            new Course(1, "DSA", null, new ArrayList<>()),
            new Course(2, "TOC", null, new ArrayList<>()),
            new Course(3, "ML", null, new ArrayList<>())

    ));

    public CourseCatalogueDAO() {
        courseCatalogue = new CourseCatalogue(1, "Catalogue", courseList);
    }

    public CourseCatalogue getCourseCatalogue() {
        return courseCatalogue;
    }

    public Course getCourseById(int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Persisting Profession details");
            String sqlQuery = "select * from course where course_id = " + courseId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Course course = new Course(
                    resultSet.getInt("courseId"),
                    resultSet.getString("course_name"),
                    new ProfessorDAO().getProfessorById(resultSet.getInt("professor_id")),
                    new ArrayList<>()
            );
            return course;
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
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Persisting Profession details");
            String sqlQuery = "update course set professor_id = " +
                    course.getProfessor().getProfessorId() + " where course_id = " + course.getCourseId();
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate();

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
