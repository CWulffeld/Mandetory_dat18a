package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class DBConfig {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connect = DriverManager
                .getConnection("jdbc:mysql://den1.mysql1.gear.host:3306/dat18a2", "dat18a2", "Lp724V-Ec?BN");

        return connect;
    }
}
