package com.example.demo.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Blog {

    private int blogID;
    private String title;
    private String text;


    public Blog(int blogID, String title, String text) {
        this.blogID = blogID;
        this.title = title;
        this.text = text;
    }

    public Blog(String title, String text){

        this.title=title;
        this.text=text;
    }

    public Blog(){}

    public int getBlogID() {
        return blogID;
    }
    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
