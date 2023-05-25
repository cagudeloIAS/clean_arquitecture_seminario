package com.co.ias.clean_example.infraestructure.entrypoint;

import com.co.ias.clean_example.domain.model.dto.BookDTO;
import com.co.ias.clean_example.domain.usecase.BookUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BookApiRest {

    private final BookUseCase bookUseCase;

    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookUseCase.createBook(bookDTO), HttpStatus.CREATED);
    }


    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(String isbn) {
        return new ResponseEntity<>(bookUseCase.getBookByIsbn(isbn), HttpStatus.OK);
    }

}
