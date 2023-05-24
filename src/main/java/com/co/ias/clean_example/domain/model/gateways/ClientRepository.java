package com.co.ias.clean_example.domain.model.gateways;

import com.co.ias.clean_example.domain.model.Client;

public interface ClientRepository {
    Client saveClient(Client client);
}
