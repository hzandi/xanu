package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.modules.city.City;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    Client update(Client client);
    void delete(Long id);
    Client getById(Long id);
    Client getByUsername(String username);
    List<Client> getAll();
    Page<Client> paging(Integer page, Integer size);
    List<Client> search(List<SearchCriteria> searchCriteria);
}