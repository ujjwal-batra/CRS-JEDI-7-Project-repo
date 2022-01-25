package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class ProfessorDAO implements ProfessorDaoInterface {

    public List<Professor> professorList = new ArrayList<>(
            Arrays.asList(
                    new Professor(1, "prof1", "root", "p1@gm.com", 78945612, "Professor", "indore", "male", "CSE", new ArrayList<>()),
                    new Professor(2, "prof2", "root", "p2@gm.com", 98765432, "Professor", "bhopal", "male", "CSE", new ArrayList<>()),
                    new Professor(3, "prof3", "root", "p3@gm.com", 78945612, "Professor", "indore", "male", "CSE", new ArrayList<>()),
                    new Professor(4, "prof4", "root", "p4@gm.com", 98765432, "Professor", "bhopal", "male", "CSE", new ArrayList<>()),
                    new Professor(5, "prof5", "root", "p5@gm.com", 78945612, "Professor", "indore", "male", "CSE", new ArrayList<>()),
                    new Professor(6, "prof6", "root", "p6@gm.com", 98765432, "Professor", "bhopal", "male", "CSE", new ArrayList<>()),
                    new Professor(7, "prof7", "root", "p7@gm.com", 78945612, "Professor", "indore", "male", "CSE", new ArrayList<>())
            )
    );

    public void saveProfessor(Professor professor) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Persisting Profession details");
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

    public Professor getProfessorById(int professorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DBUtils.getConnection();
            System.out.println("Persisting Profession details");
            String sqlQuery = "select * from professor where professor_id = " + professorId;
            statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Professor professor = new Professor(
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
            return professor;
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

    public int checkCredentials(String email, String password) {
        for (Professor professor : professorList) {
            if (Objects.equals(professor.getEmailId(), email) && Objects.equals(professor.getPassword(), password))
                return professor.getProfessorId();
        }
        return -1;

    }

    public int updateCredentials(String email, String password) {
        for (Professor professor : professorList) {
            if (Objects.equals(professor.getEmailId(), email))
                professor.setPassword(password);

        }
        return -1;

    }

}
