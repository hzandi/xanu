package com.kurdestan.xanu.modules.client_property;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientPropertyMapper {

    ClientProperty toClientProperty(ClientPropertyDTO clientPropertyDTO);
    ClientPropertyDTO toClientPropertyDTO(ClientProperty clientProperty);
    List<ClientProperty> toClientPropertyList(List<ClientPropertyDTO> clientPropertyDTOS);
    List<ClientPropertyDTO> toClientPropertyDTOList(List<ClientProperty> clientProperties);
}
