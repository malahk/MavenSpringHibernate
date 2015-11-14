package com.kirill.app.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 14.11.2015
 */
public class Connector {

    private static String URL = "jdbc:mysql://localhost:3306/zoo_db";
    private static String USER = "root";
    private static String PASSWORD = "toor";
    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connector() {

    }

    public static Connection getConn() {
        return conn;
    }

    public static void closeConn() {

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
