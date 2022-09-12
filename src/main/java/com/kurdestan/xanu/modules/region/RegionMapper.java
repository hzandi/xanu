package com.kurdestan.xanu.modules.region;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    Region toRegion(RegionDTO regionDTO);
    RegionDTO toRegionDTO(Region region);
    List<Region> toRegionList(List<RegionDTO> regionDTOS);
    List<RegionDTO> toRegionDTOList(List<Region> regions);
}
