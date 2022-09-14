package com.kurdestan.xanu.modules.client_house;

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
public class ClientHouseServiceImpl implements ClientHouseService {

    private final ClientHouseRepository clientHouseRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientHouseCache", allEntries = true),
    })
    public ClientHouse save(ClientHouse clientHouse) {
        return clientHouseRepository.save(clientHouse);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientHouseCache", allEntries = true),
    })
    public ClientHouse update(ClientHouse clientHouse) {
        ClientHouse lastSavedClientHouse = getById(clientHouse.getId());
        lastSavedClientHouse.setClient(clientHouse.getClient());
        lastSavedClientHouse.setHouse(clientHouse.getHouse());
        return clientHouseRepository.save(lastSavedClientHouse);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "clientHouseCache", allEntries = true),
    })
    public void delete(Long id) {
        getById(id);
        clientHouseRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "clientHouseCache", key = "#id")
    public ClientHouse getById(Long id) {
        Optional<ClientHouse> optionalVehicle = clientHouseRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("ClientHouse Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "clientHouseCache", key = "#clientId")
    public List<ClientHouse> getAllByClientId(Long clientId) {
        return clientHouseRepository.findAllByClient_Id(clientId);
    }

    @Override
    @Cacheable(value = "clientHouseCache", key = "#HouseId")
    public List<ClientHouse> getAllByHouseId(Long HouseId) {
        return clientHouseRepository.findAllByHouse_Id(HouseId);
    }

    @Override
    @Cacheable(value = "clientHouseCache")
    public List<ClientHouse> getAll() {
        return (List<ClientHouse>) clientHouseRepository.findAll();
    }

    @Override
    public Page<ClientHouse> paging(Integer page, Integer size) {
        return clientHouseRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public List<ClientHouse> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<ClientHouse> clientHouseSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> clientHouseSpecification.add(criteria));
        return clientHouseRepository.findAll(clientHouseSpecification);
    }

}


