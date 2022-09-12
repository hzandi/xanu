package com.kurdestan.xanu.modules.house;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends
        PagingAndSortingRepository<House, Long>,
        JpaSpecificationExecutor<House> {

    Optional<House> findByTitle(String title);
    Page<House> findAllByRegion_Id(Long regionId, Pageable pageable);
    Page<House> findAllByAgency_Id(Long agencyId, Pageable pageable);
    Page<House> findAll(Pageable pageable);
    List<House> findAll(Specification<House> specification);

}
