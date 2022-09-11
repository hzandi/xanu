package com.kurdestan.xanu.modules.agency;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgencyMapper {

    Agency toAgency(AgencyDTO agencyDTO);
    AgencyDTO toAgencyDTO(Agency agency);
    List<Agency> toAgencyList(List<AgencyDTO> agencyDTOS);
    List<AgencyDTO> toAgencyDTOList(List<Agency> agencies);
}
