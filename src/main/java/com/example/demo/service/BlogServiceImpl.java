package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;


    @Override
    public List<Blog> getAllBlogs() {
        return null;
    }

    @Override
    public void addBlog(Blog blog) throws SQLException, ClassNotFoundException {
        blogRepository.insertBlog(blog.getTitle(), blog.getText());


    }
}
