package com.co.ias.clean_example.infraestructure.entrypoint;

import com.co.ias.clean_example.domain.model.dto.BookDTO;
import com.co.ias.clean_example.domain.usecase.BookUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookApiRest.class)
@ActiveProfiles("test")
class BookApiRestTest {

    @MockBean
    private BookUseCase bookUseCase;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void createBook() throws Exception {

        //Arrange
        BookDTO bookDTO = new BookDTO("title", "author", "isbn");
        when(bookUseCase.createBook(any(BookDTO.class))).thenReturn(bookDTO);
        ObjectMapper objectMapper = new ObjectMapper();

        //Act & Assert
        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO)))
                .andDo(print()) //Assert
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(bookDTO)));
    }

    @Test
    void getBookByIsbn() {
    }
}