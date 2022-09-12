package com.kurdestan.xanu.modules.agency;

import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.common.SearchSpecification;
import com.kurdestan.xanu.common.exception.NotFoundException;
import com.kurdestan.xanu.modules.house.House;
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
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "agencyCache", allEntries = true),
    })
    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "agencyCache", allEntries = true),
    })
    public Agency update(Agency agency) {
        Agency lastSavedAgency = getById(agency.getId());
        lastSavedAgency.setName(agency.getName());
        lastSavedAgency.setAddress(agency.getAddress());
        lastSavedAgency.setLocation(agency.getLocation());
        lastSavedAgency.setImage(agency.getImage());
        lastSavedAgency.setSlogan(agency.getSlogan());
        return agencyRepository.save(lastSavedAgency);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "agencyCache", allEntries = true),
    })
    public void delete(Long id) {
        getById(id);
        agencyRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "agencyCache", key = "#id")
    public Agency getById(Long id) {
        Optional<Agency> optionalAgency = agencyRepository.findById(id);
        if (optionalAgency.isEmpty()) {
            throw new NotFoundException("Agency Not Found!");
        }
        return optionalAgency.get();
    }

    @Override
    public Page<Agency> paging(Integer page, Integer size) {
        return agencyRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public Page<Agency> pagingByRegionId(Long regionId, Integer page, Integer size) {
        return agencyRepository.findAllByRegion_Id(regionId, PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public List<Agency> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Agency> agencySpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> agencySpecification.add(criteria));
        return agencyRepository.findAll(agencySpecification);
    }

}


