package com.co.ias.clean_example.domain.usecase;

import com.co.ias.clean_example.domain.model.Book;
import com.co.ias.clean_example.domain.model.dto.BookDTO;
import com.co.ias.clean_example.domain.model.gateways.BookRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BookUseCase {
    private final BookRepository bookRepository;

    public BookDTO createBook(BookDTO bookDTO) {
        return BookDTO
                .fromDomain(
                        bookRepository.saveBook(bookDTO.toDomain())
                );
    }

    public BookDTO getBookByIsbn(String isbn) {
        return BookDTO
                .fromDomain(
                        bookRepository.getBookByIsbn(isbn)
                );
    }
}
