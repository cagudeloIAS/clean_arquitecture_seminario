package com.co.ias.clean_example.infraestructure.adapters.entity;

import com.co.ias.clean_example.domain.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDBO {
    @Id
    private String isbn;
    private String title;
    private String author;
    private Boolean isAvailable;


   /* public BookDBO fromDomain(Book book) {
        return  new BookDBO(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getIsAvailable());
    }*/

    public static BookDBO fromDomain(Book book) {
        return BookDBO.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    public static Book toDomain(BookDBO bookDBO) {
        return new Book(bookDBO.getTitle(), bookDBO.getAuthor(), bookDBO.getIsbn());
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
