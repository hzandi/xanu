package com.kurdestan.xanu.modules.client;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(ClientDTO clientDTO);
    ClientDTO toClientDTO(Client client);
    List<Client> toClientList(List<ClientDTO> clientDTOS);
    List<ClientDTO> toClientDTOList(List<Client> clients);
}
