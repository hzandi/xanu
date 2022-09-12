package com.kurdestan.xanu.modules.city;

import com.kurdestan.xanu.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "cityCache", allEntries = true),
    })
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "cityCache", allEntries = true),
    })
    public City update(City city) {
        City lastSavedCity = getById(city.getId());
        lastSavedCity.setName(city.getName());
        lastSavedCity.setRegions(city.getRegions());
        return cityRepository.save(lastSavedCity);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "cityCache", allEntries = true),
    })
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "cityCache", key = "#id")
    public City getById(Long id) {
        Optional<City> optionalVehicle = cityRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("City Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "cityCache", key = "#name")
    public City getByName(String name) {
        Optional<City> optionalCity = cityRepository.findByName(name);
        if (optionalCity.isEmpty()) {
            throw new NotFoundException("City Not Found!");
        }
        return optionalCity.get();
    }

    @Override
    @Cacheable(value = "cityCache")
    public List<City> getAll() {
        return (List<City>) cityRepository.findAll();
    }

}


