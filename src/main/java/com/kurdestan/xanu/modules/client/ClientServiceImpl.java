package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
        lastSavedClient.setSavedProperty(client.getSavedProperty());
        return clientRepository.save(lastSavedClient);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientCache", allEntries = true),
    })
    public void delete(Long id) {
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

}


