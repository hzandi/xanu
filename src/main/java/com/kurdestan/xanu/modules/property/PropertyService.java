package com.kurdestan.xanu.modules.property;

import com.kurdestan.xanu.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PropertyService {
    Property save(Property property);
    Property update(Property property);
    void delete(Long id);
    Property getById(Long id);
    Property getByTitle(String title);
    List<Property> getAll();

    Page<Property> paging(Integer page, Integer size);
    Page<Property> pagingByAgencyId(Long agencyId, Integer page, Integer size);
    Page<Property> pagingByRegionId(Long regionId, Integer page, Integer size);
    List<Property> search(List<SearchCriteria> searchCriteria);
}