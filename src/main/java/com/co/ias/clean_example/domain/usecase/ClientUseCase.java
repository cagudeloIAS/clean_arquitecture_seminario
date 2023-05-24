package com.co.ias.clean_example.domain.usecase;

import com.co.ias.clean_example.domain.model.Client;
import com.co.ias.clean_example.domain.model.gateways.ClientRepository;

public class ClientUseCase {

    private final ClientRepository clientRepository;

    public ClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.saveClient(client);
    }
}
