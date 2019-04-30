package com.example.demo.service;

import com.example.demo.model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface BlogService {


    public List<Blog> getAllBlogs();

    public void addBlog(Blog blog) throws SQLException, ClassNotFoundException;
}
