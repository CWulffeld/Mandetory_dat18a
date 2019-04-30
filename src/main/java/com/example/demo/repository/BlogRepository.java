package com.example.demo.repository;

import com.example.demo.config.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class BlogRepository {



    public static void createblogTable() throws SQLException, ClassNotFoundException {




        System.out.println("1");

        Statement stmt = DBConfig.getConnection().createStatement();

        System.out.println("5");
        String sql_createBlogTable = "CREATE TABLE IF NOT EXISTS blogs" +
                "(" +
                "Blog_ID int," +
                " Blog_Title varchar(100)," +
                " Blog_Tekst varchar(10000) " +
                ")";

        System.out.println("6");
        stmt.execute(sql_createBlogTable);
//        SQLExecute(sql_createBlogTable);

        System.out.println("7");
        stmt.close();
    }


//    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException {
//        stmt.execute(SQL);

}
