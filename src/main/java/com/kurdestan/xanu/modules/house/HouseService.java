package com.kurdestan.xanu.modules.house;

import com.kurdestan.xanu.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HouseService {
    House save(House house);
    House update(House house);
    void delete(Long id);
    House getById(Long id);
    House getByTitle(String title);
    Page<House> paging(Integer page, Integer size);
    Page<House> pagingByAgencyId(Long agencyId, Integer page, Integer size);
    Page<House> pagingByRegionId(Long regionId, Integer page, Integer size);
    List<House> search(List<SearchCriteria> searchCriteria);
}