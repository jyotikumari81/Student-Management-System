package com.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/student_dp";
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}