package com.kurdestan.xanu.modules.city;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.modules.agency.Agency;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
    City save(City city);
    City update(City city);
    void delete(Long id);
    City getById(Long id);

    City getByName(String name);
    List<City> getAll();

    Page<City> paging(Integer page, Integer size);
    List<City> search(List<SearchCriteria> searchCriteria);
}