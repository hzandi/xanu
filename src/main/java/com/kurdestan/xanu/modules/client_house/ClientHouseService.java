package com.kurdestan.xanu.modules.client_house;

import com.kurdestan.xanu.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientHouseService {
    ClientHouse save(ClientHouse clientHouse);
    ClientHouse update(ClientHouse clientHouse);
    void delete(Long id);
    ClientHouse getById(Long id);
    List<ClientHouse> getAllByHouseId(Long HouseId);
    List<ClientHouse> getAllByClientId(Long clientId);
    List<ClientHouse> getAll();

    Page<ClientHouse> paging(Integer page, Integer size);
    List<ClientHouse> search(List<SearchCriteria> searchCriteria);
}