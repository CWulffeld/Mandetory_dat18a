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


    public void createblogTable() throws SQLException, ClassNotFoundException {
        String sql_createBlogTable = "CREATE TABLE IF NOT EXISTS blogs" +
                "(" +
                "Blog_ID int," +
                " Blog_Title varchar(100)," +
                " Blog_Tekst varchar(10000) " +
                ")";


        SQLExecute(sql_createBlogTable);

    }


    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException {
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();

    }
}
