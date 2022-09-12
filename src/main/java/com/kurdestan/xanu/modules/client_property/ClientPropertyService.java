package com.kurdestan.xanu.modules.client_property;

import java.util.List;

public interface ClientPropertyService {
    ClientProperty save(ClientProperty clientProperty);
    ClientProperty update(ClientProperty clientProperty);
    void delete(Long id);
    ClientProperty getById(Long id);
    List<ClientProperty> getAllByPropertyId(Long propertyId);
    List<ClientProperty> getAllByClientId(Long clientId);
    List<ClientProperty> getAll();
}