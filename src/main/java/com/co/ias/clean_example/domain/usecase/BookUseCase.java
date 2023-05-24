package com.co.ias.clean_example.domain.usecase;

import com.co.ias.clean_example.domain.model.Book;
import com.co.ias.clean_example.domain.model.gateways.BookRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookUseCase {
    private final BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.saveBook(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }
}
