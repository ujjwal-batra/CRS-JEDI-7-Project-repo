package com.crs.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crs_app?characterEncoding=latin1";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static Connection getConnection() {

        Connection connection = null;
        if (connection != null)
            return connection;
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to database...");
                connection = DriverManager.getConnection(DB_URL,USER,PASS);

            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}