package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.common.SearchSpecification;
import com.kurdestan.xanu.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientCache", allEntries = true),
    })
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientCache", allEntries = true),
    })
    public Client update(Client client) {
        Client lastSavedClient = getById(client.getId());
        lastSavedClient.setName(client.getName());
        lastSavedClient.setUsername(client.getUsername());
        lastSavedClient.setEmail(client.getEmail());
        lastSavedClient.setPassword(client.getPassword());
        lastSavedClient.setPhone(client.getPhone());
        lastSavedClient.setHouseBookmark(client.getHouseBookmark());
        return clientRepository.save(lastSavedClient);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientCache", allEntries = true),
    })
    public void delete(Long id) {
        getById(id);
        clientRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "clientCache", key = "#id")
    public Client getById(Long id) {
        Optional<Client> optionalVehicle = clientRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("Client Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "clientCache", key = "#username")
    public Client getByUsername(String username) {
        Optional<Client> optionalClient = clientRepository.findByUsername(username);
        if (optionalClient.isEmpty()) {
            throw new NotFoundException("Client Not Found!");
        }
        return optionalClient.get();
    }

    @Override
    @Cacheable(value = "clientCache")
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Page<Client> paging(Integer page, Integer size) {
        return clientRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public List<Client> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Client> clientSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> clientSpecification.add(criteria));
        return clientRepository.findAll(clientSpecification);
    }

}


