package com.kurdestan.xanu.modules.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends
        PagingAndSortingRepository<City, Long>,
        JpaSpecificationExecutor<City> {

    Optional<City> findByName(String name);
    Page<City> findAll(Pageable pageable);
    List<City> findAll(Specification<City> specification);
}
