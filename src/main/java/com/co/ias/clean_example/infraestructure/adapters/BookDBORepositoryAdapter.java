package com.co.ias.clean_example.infraestructure.adapters;

import com.co.ias.clean_example.domain.model.Book;
import com.co.ias.clean_example.domain.model.gateways.BookRepository;
import com.co.ias.clean_example.infraestructure.adapters.entity.BookDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BookDBORepositoryAdapter implements BookRepository {

    private final BookDBORepository bookDBORepository;
    @Override
    public Book saveBook(Book book) {
        BookDBO bookDBO = BookDBO.fromDomain(book);
        bookDBO.setAvailable(true);
        return BookDBO.toDomain(bookDBORepository.save(bookDBO));
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookDBORepository.findById(isbn)
                .map(BookDBO::toDomain)
                .orElseThrow(RuntimeException::new);
    }
}
