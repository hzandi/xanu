package com.kurdestan.xanu.modules.city;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toCity(CityDTO cityDTO);
    CityDTO toCityDTO(City city);
    List<City> toCityList(List<CityDTO> cityDTOS);
    List<CityDTO> toCityDTOList(List<City> cities);
}
