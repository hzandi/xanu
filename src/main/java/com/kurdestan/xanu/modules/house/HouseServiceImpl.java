package com.kurdestan.xanu.modules.house;

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
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "houseCache", allEntries = true),
    })
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "houseCache", allEntries = true),
    })
    public House update(House house) {
        House lastSavedHouse = getById(house.getId());
        lastSavedHouse.setTitle(house.getTitle());
        lastSavedHouse.setAddress(house.getAddress());
        lastSavedHouse.setArea(house.getArea());
        lastSavedHouse.setFloor(house.getFloor());
        lastSavedHouse.setHasBalcony(house.getHasBalcony());
        lastSavedHouse.setParking(house.getParking());
        lastSavedHouse.setHasWarehouse(house.getHasWarehouse());
        lastSavedHouse.setLocation(house.getLocation());
        lastSavedHouse.setRoomNumber(house.getRoomNumber());
        lastSavedHouse.setRentPrice(house.getRentPrice());
        lastSavedHouse.setSalePrice(house.getSalePrice());
        lastSavedHouse.setType(house.getType());
        lastSavedHouse.setAgency(house.getAgency());
        lastSavedHouse.setRegion(house.getRegion());
        lastSavedHouse.setImages(house.getImages());
        return houseRepository.save(lastSavedHouse);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "houseCache", allEntries = true),
    })
    public void delete(Long id) {
        getById(id);
        houseRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "houseCache", key = "#id")
    public House getById(Long id) {
        Optional<House> optionalVehicle = houseRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("House Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "houseCache", key = "#title")
    public House getByTitle(String title) {
        Optional<House> optionalHouse = houseRepository.findByTitle(title);
        if (optionalHouse.isEmpty()) {
            throw new NotFoundException("House Not Found!");
        }
        return optionalHouse.get();
    }

    @Override
    @Cacheable(value = "houseCache")
    public Page<House> paging(Integer page, Integer size) {
        return houseRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    @Cacheable(value = "houseCache")
    public Page<House> pagingByRegionId(Long regionId, Integer page, Integer size) {
        return houseRepository.findAllByRegion_Id(regionId, PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    @Cacheable(value = "houseCache")
    public Page<House> pagingByAgencyId(Long agencyId, Integer page, Integer size) {
        return houseRepository.findAllByAgency_Id(agencyId, PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    @Cacheable(value = "houseCache")
    public List<House> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<House> HouseSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> HouseSpecification.add(criteria));
        return houseRepository.findAll(HouseSpecification);
    }
}


