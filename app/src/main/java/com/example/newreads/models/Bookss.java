package com.example.newreads.models;

import java.util.ArrayList;

public class Bookss {
    private String Title;
    private String Author;
    private String id;



    public Bookss(String title, String author, String id) {
       this.Title =title;
       this.Author = author;
       this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getId() {return id;}



}
