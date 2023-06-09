package com.co.ias.clean_example.domain.model.gateways;

import com.co.ias.clean_example.domain.model.Book;

import java.util.Optional;

public interface BookRepository {
    Book saveBook(Book book);

    Book getBookByIsbn(String isbn);
}
