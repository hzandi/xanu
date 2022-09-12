package com.kurdestan.xanu.modules.agency;

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
    @Cacheable(value = "agencyCache")
    public List<Agency> getAll() {
        return (List<Agency>) agencyRepository.findAll();
    }
}


