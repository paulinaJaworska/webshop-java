package com.codecool.shop.config;

import java.sql.* ;

public class DBConfig  {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/codecoolshop";

    //  Database credentials
    private String url = "jdbc:postgresql://localhost:5432/codecoolshop"; // System.getenv todo
    private static final String USER = "paulina";
    private static final String PASS = "codecool";

    public Connection getConnection() {
        Connection conn = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER); // OPTIONAL
            //STEP 3: Open a connection - auto close
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            //Handle errors for JDBC
            e.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return conn;
    }
}
