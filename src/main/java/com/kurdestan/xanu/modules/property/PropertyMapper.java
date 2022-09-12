package com.kurdestan.xanu.modules.property;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyMapper {

    Property toProperty(PropertyDTO propertyDTO);
    PropertyDTO toPropertyDTO(Property property);
    List<Property> toPropertyList(List<PropertyDTO> propertyDTOS);
    List<PropertyDTO> toPropertyDTOList(List<Property> properties);
}
