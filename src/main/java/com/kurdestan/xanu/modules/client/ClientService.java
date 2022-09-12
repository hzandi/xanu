package com.kurdestan.xanu.modules.client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    Client update(Client client);
    void delete(Long id);
    Client getById(Long id);
    Client getByUsername(String username);
    List<Client> getAll();
}