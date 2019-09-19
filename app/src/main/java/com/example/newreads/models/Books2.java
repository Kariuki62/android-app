package com.example.newreads.models;

import java.util.ArrayList;

public class Books2 {
    private String Title;
    private String Author;
    private String id;
    private String imageUrl;



    public Books2(String title, String author, String id) {
       this.Title =title;
       this.Author = author;
       this.id = id;

    }

    public String getTitle() {
        return Title;
    }

    public String getImageUrl() { return imageUrl; }

    public String getAuthor() { return Author; }

    public String getId() {return id;}



}
