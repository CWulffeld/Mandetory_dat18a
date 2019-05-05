package com.example.demo.repository;

import com.example.demo.config.DBConfig;

import org.springframework.stereotype.Repository;
import java.sql.*;

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

    public void insertBlog(String title, String text) throws SQLException, ClassNotFoundException {

        String sql_insertBlog = "INSERT INTO blogs" +
                "(Blog_Title, " +
                "Blog_Tekst " + ")" +

                "VALUES " +
                "('" + title + "', '" +
                text  +
                "')";
        SQLExecute(sql_insertBlog);

    }

  public ResultSet selectAllBlogs() throws SQLException, ClassNotFoundException {

    Statement stmt = DBConfig.getConnection().createStatement();
    String sql_selectBlog = "SELECT Blog_title, Blog_tekst FROM blogs ORDER BY Blog_ID desc";

    ResultSet resultset = stmt.executeQuery(sql_selectBlog);
     return resultset;
   }


    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException {
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();

    }
}
