package com.kurdestan.xanu.modules.property;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends
        PagingAndSortingRepository<Property, Long>,
        JpaSpecificationExecutor<Property> {

    Optional<Property> findByTitle(String title);
    Page<Property> findAllByRegion_Id(Long regionId, Pageable pageable);
    Page<Property> findAllByAgency_Id(Long agencyId, Pageable pageable);
    Page<Property> findAll(Pageable pageable);
    List<Property> findAll(Specification<Property> specification);

}
