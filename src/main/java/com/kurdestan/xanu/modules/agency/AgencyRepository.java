package com.kurdestan.xanu.modules.agency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyRepository extends
        PagingAndSortingRepository<Agency, Long>,
        JpaSpecificationExecutor<Agency> {

    Agency findByName(String name);
    Page<Agency> findAll(Pageable pageable);
    List<Agency> findAll(Specification<Agency> specification);
}
