package com.co.ias.clean_example.domain.model;

public class Book {

    private String title;
    private String author;
    private String isbn;

    private Boolean isAvailable;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
