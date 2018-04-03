package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalConnectionMaker implements ConnectionMaker {
    @Override
    public Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_pract_01", "root", "password");
        return con;
    }
}
