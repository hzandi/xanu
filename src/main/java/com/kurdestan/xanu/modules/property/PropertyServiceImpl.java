package com.kurdestan.xanu.modules.property;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.common.SearchSpecification;
import com.kurdestan.xanu.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "propertyCache", allEntries = true),
    })
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "propertyCache", allEntries = true),
    })
    public Property update(Property property) {
        Property lastSavedProperty = getById(property.getId());
        lastSavedProperty.setTitle(property.getTitle());
        lastSavedProperty.setAddress(property.getAddress());
        lastSavedProperty.setArea(property.getArea());
        lastSavedProperty.setFloor(property.getFloor());
        lastSavedProperty.setHasBalcony(property.getHasBalcony());
        lastSavedProperty.setParking(property.getParking());
        lastSavedProperty.setHasWarehouse(property.getHasWarehouse());
        lastSavedProperty.setLocation(property.getLocation());
        lastSavedProperty.setRoomNumber(property.getRoomNumber());
        lastSavedProperty.setRentPrice(property.getRentPrice());
        lastSavedProperty.setSalePrice(property.getSalePrice());
        lastSavedProperty.setType(property.getType());
        lastSavedProperty.setAgency(property.getAgency());
        lastSavedProperty.setRegion(property.getRegion());
        lastSavedProperty.setImages(property.getImages());
        return propertyRepository.save(lastSavedProperty);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "propertyCache", allEntries = true),
    })
    public void delete(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "propertyCache", key = "#id")
    public Property getById(Long id) {
        Optional<Property> optionalVehicle = propertyRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("Property Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "propertyCache", key = "#title")
    public Property getByTitle(String title) {
        Optional<Property> optionalProperty = propertyRepository.findByTitle(title);
        if (optionalProperty.isEmpty()) {
            throw new NotFoundException("Property Not Found!");
        }
        return optionalProperty.get();
    }

    @Override
    @Cacheable(value = "propertyCache")
    public List<Property> getAll() {
        return (List<Property>) propertyRepository.findAll();
    }

    @Override
    @Cacheable(value = "propertyCache")
    public Page<Property> paging(Integer page, Integer size) {
        return propertyRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    @Cacheable(value = "propertyCache")
    public Page<Property> pagingByRegionId(Long regionId, Integer page, Integer size) {
        return propertyRepository.findAllByRegion_Id(regionId, PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    @Cacheable(value = "propertyCache")
    public Page<Property> pagingByAgencyId(Long agencyId, Integer page, Integer size) {
        return propertyRepository.findAllByAgency_Id(agencyId, PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    @Cacheable(value = "propertyCache")
    public List<Property> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Property> propertySpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> propertySpecification.add(criteria));
        return propertyRepository.findAll(propertySpecification);
    }
}


