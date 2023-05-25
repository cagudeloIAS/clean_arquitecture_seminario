package com.co.ias.clean_example.domain.model.dto;

import com.co.ias.clean_example.domain.model.Book;

public class BookDTO {

    private String title;
    private String author;
    private String isbn;

    public Book toDomain() {
        return new Book(title, author, isbn);
    }

    public static BookDTO fromDomain(Book book) {
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getIsbn());
    }

    public BookDTO(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
