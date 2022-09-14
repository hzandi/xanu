package com.kurdestan.xanu.modules.region;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.common.SearchSpecification;
import com.kurdestan.xanu.common.exception.NotFoundException;
import com.kurdestan.xanu.modules.client.Client;
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
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "regionCache", allEntries = true),
    })
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "regionCache", allEntries = true),
    })
    public Region update(Region region) {
        Region lastSavedRegion = getById(region.getId());
        lastSavedRegion.setName(region.getName());
        lastSavedRegion.setCity(region.getCity());
        return regionRepository.save(lastSavedRegion);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "regionCache", allEntries = true),
    })
    public void delete(Long id) {
        getById(id);
        regionRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "regionCache", key = "#id")
    public Region getById(Long id) {
        Optional<Region> optionalVehicle = regionRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("Region Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "regionCache", key = "#name")
    public Region getByName(String name) {
        Optional<Region> optionalRegion = regionRepository.findByName(name);
        if (optionalRegion.isEmpty()) {
            throw new NotFoundException("Region Not Found!");
        }
        return optionalRegion.get();
    }

    @Override
    @Cacheable(value = "regionCache")
    public List<Region> getAllByCityId(Long cityId) {
        return regionRepository.findAllByCity_Id(cityId);
    }

    @Override
    @Cacheable(value = "regionCache")
    public List<Region> getAll() {
        return (List<Region>) regionRepository.findAll();
    }

    @Override
    public Page<Region> paging(Integer page, Integer size) {
        return regionRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public List<Region> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Region> regionSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> regionSpecification.add(criteria));
        return regionRepository.findAll(regionSpecification);
    }

}


