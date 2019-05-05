package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogs() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = blogRepository.selectAllBlogs();

        List<Blog> blogs = new ArrayList<>();

        while (resultSet.next()){

            String titel = resultSet.getString("Blog_Title");
            String tekst = resultSet.getString("Blog_tekst");

            blogs.add(new Blog(titel,tekst));
        }
        return blogs;
    }

    @Override
    public void addBlog(Blog blog) throws SQLException, ClassNotFoundException {
        blogRepository.insertBlog(blog.getTitle(), blog.getText());


    }
}
