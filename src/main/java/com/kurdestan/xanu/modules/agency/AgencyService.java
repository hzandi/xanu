package com.kurdestan.xanu.modules.agency;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.modules.house.House;
import org.springframework.data.domain.Page;

import java.util.List;


public interface AgencyService {
    Agency save(Agency agency);
    Agency update(Agency agency);
    void delete(Long id);
    Agency getById(Long id);

    Page<Agency> paging(Integer page, Integer size);
    Page<Agency> pagingByRegionId(Long regionId, Integer page, Integer size);
    List<Agency> search(List<SearchCriteria> searchCriteria);
}