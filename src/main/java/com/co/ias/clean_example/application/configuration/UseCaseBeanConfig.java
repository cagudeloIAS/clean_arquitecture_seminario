package com.co.ias.clean_example.application.configuration;

import com.co.ias.clean_example.domain.model.gateways.BookRepository;
import com.co.ias.clean_example.domain.model.gateways.ClientRepository;
import com.co.ias.clean_example.domain.usecase.BookUseCase;
import com.co.ias.clean_example.domain.usecase.ClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public BookUseCase bookUseCase(BookRepository bookRepository) {
        return new BookUseCase(bookRepository);
    }

    @Bean
    public ClientUseCase clientUseCase(ClientRepository clientRepository) {
        return new ClientUseCase(clientRepository);
    }
}
