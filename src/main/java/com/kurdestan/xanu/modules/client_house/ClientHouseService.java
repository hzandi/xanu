package com.kurdestan.xanu.modules.client_house;

import java.util.List;

public interface ClientHouseService {
    ClientHouse save(ClientHouse clientHouse);
    ClientHouse update(ClientHouse clientHouse);
    void delete(Long id);
    ClientHouse getById(Long id);
    List<ClientHouse> getAllByHouseId(Long HouseId);
    List<ClientHouse> getAllByClientId(Long clientId);
    List<ClientHouse> getAll();
}