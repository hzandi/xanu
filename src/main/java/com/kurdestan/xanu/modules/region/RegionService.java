package com.kurdestan.xanu.modules.region;

import com.kurdestan.xanu.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RegionService {
    Region save(Region region);
    Region update(Region region);
    void delete(Long id);
    Region getById(Long id);
    Region getByName(String name);
    List<Region> getAllByCityId(Long cityId);
    List<Region> getAll();

    Page<Region> paging(Integer page, Integer size);
    List<Region> search(List<SearchCriteria> searchCriteria);
}