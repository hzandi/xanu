package com.kurdestan.xanu.modules.house;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    House toHouse(HouseDTO houseDTO);
    HouseDTO toHouseDTO(House house);
    List<House> toHouseList(List<HouseDTO> houseDTOS);
    List<HouseDTO> toHouseDTOList(List<House> properties);
}
