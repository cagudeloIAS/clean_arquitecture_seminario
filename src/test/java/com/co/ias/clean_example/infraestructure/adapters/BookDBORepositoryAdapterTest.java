package com.co.ias.clean_example.infraestructure.adapters;

import com.co.ias.clean_example.domain.model.Book;
import com.co.ias.clean_example.infraestructure.adapters.entity.BookDBO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class BookDBORepositoryAdapterTest {

    @Autowired
    private  BookDBORepository bookDBORepository;

    @InjectMocks
    private BookDBORepositoryAdapter bookDBORepositoryAdapter;

    @BeforeEach
    void setUp() {
        bookDBORepositoryAdapter = new BookDBORepositoryAdapter(bookDBORepository);
    }

    @Test
    void saveBook() {
        //arange
        Book book = new Book("title", "author", "isbn");
        //act
        Book bookSaved = bookDBORepositoryAdapter.saveBook(book);
        //assert
        Optional<BookDBO> bookDBO = bookDBORepository.findById(book.getIsbn());
        assertTrue(bookDBO.isPresent());

    }
}