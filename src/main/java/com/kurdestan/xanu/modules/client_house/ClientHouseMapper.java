package com.kurdestan.xanu.modules.client_house;

import com.kurdestan.xanu.common.BaseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientHouseMapper {

    ClientHouse toClientHouse(ClientHouseDTO clientHouseDTO);
    ClientHouseDTO toClientHouseDTO(ClientHouse clientHouse);
    List<ClientHouse> toClientHouseList(List<ClientHouseDTO> clientHouseDTOS);
    List<ClientHouseDTO> toClientHouseDTOList(List<ClientHouse> clientApiModelProperty);
}
