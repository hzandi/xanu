package com.kurdestan.xanu.modules.city;

import java.util.List;

public interface CityService {
    City save(City city);
    City update(City city);
    void delete(Long id);
    City getById(Long id);

    City getByName(String name);
    List<City> getAll();
}