package com.kurdestan.xanu.modules.client_property;

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
public class ClientPropertyServiceImpl implements ClientPropertyService {

    private final ClientPropertyRepository clientPropertyRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientPropertyCache", allEntries = true),
    })
    public ClientProperty save(ClientProperty clientProperty) {
        return clientPropertyRepository.save(clientProperty);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientPropertyCache", allEntries = true),
    })
    public ClientProperty update(ClientProperty clientProperty) {
        ClientProperty lastSavedClientProperty = getById(clientProperty.getId());
        lastSavedClientProperty.setClient(clientProperty.getClient());
        lastSavedClientProperty.setProperty(clientProperty.getProperty());
        return clientPropertyRepository.save(lastSavedClientProperty);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientPropertyCache", allEntries = true),
    })
    public void delete(Long id) {
        clientPropertyRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "clientPropertyCache", key = "#id")
    public ClientProperty getById(Long id) {
        Optional<ClientProperty> optionalVehicle = clientPropertyRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("ClientProperty Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "clientPropertyCache", key = "#clientId")
    public List<ClientProperty> getAllByClientId(Long clientId) {
        return clientPropertyRepository.findAllByClient_Id(clientId);
    }

    @Override
    @Cacheable(value = "clientPropertyCache", key = "#propertyId")
    public List<ClientProperty> getAllByPropertyId(Long propertyId) {
        return clientPropertyRepository.findAllByProperty_Id(propertyId);
    }

    @Override
    @Cacheable(value = "clientPropertyCache")
    public List<ClientProperty> getAll() {
        return (List<ClientProperty>) clientPropertyRepository.findAll();
    }

}


