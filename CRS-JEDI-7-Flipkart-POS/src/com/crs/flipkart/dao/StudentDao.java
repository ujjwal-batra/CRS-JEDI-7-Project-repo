package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao implements StudentDaoInterface {

    private List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "stud1", "root", "stud1@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(2, "stud2", "root", "stud2@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(3, "stud3", "root", "stud3@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(4, "stud4", "root", "stud4@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(5, "stud5", "root", "stud5@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(6, "stud6", "root", "stud6@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2),
                    new Student(7, "stud7", "root", "stud7@gmail.com", 78945612, "Student", "Delhi", "male", "CSE", true, 2)
            )

    );

    public StudentDao() {
        //registerCourse();
    }

    public void getLastId(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from student";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_id"));
            }


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

    public Student saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            System.out.println(ex);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return student;
    }

    public Student getStudentById(int studentId) {
        Connection connection = null;
        PreparedStatement statement = null;
        Student student = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Persisting Student details");
            String sqlQuery = "select * from student where student_id =" + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
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

    public int checkCredentials(String email, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();

            String sqlQuery = "select * from student where email = '" + email + "' and password = '" + password + "'";
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return -1;
            } else
                return resultSet.getInt("student_id");
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

    public boolean semesterRegistration(int studentId, int semester) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from student where studentId = " + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                return false;
            }
            sqlQuery = "update student set semester = " + semester + " where studentId = " + studentId;
            ResultSet resultSet1 = statement.executeQuery(sqlQuery);
            if (!resultSet1.next())
                return false;
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
        return true;
    }

    public boolean addCourse(int studentId, int courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "insert into enrolled_course values(?, ?, ?)";
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, courseId);
            statement.setInt(2, studentId);
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

    public boolean dropCourse(int studentId, int courseId) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            statement = connection.createStatement();
            String sqlQuery = "delete from enrolled_course where student_id = " + studentId
                    + " and course_id = " + courseId;
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

    public List<Integer> viewEnrolledCourse(int studentId) {
        List<Integer> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            String sqlQuery = "select * from enrolled_course where student_id = " + studentId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                res.add(resultSet.getInt("course_id"));
            }
            return res;
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
        return res;
    }
}
