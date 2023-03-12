package org.generation.italy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.generation.italy.departementEmployees.model.data.JDBCCostants.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}