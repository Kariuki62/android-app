package com.example.newreads.models;

public class Bookss {
    private String Title;
    private String Author;
    private int id;


    public Bookss(String title, String author, int id) {
        Title = title;
        Author = author;
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getId() {
        return id;
    }
}
