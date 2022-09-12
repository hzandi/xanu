package com.kurdestan.xanu.modules.image;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ImageRepository extends
        PagingAndSortingRepository<Image, Long>,
        JpaSpecificationExecutor<Image> {

    Optional<Image> findByName(String name);
    List<Image> findAllByHouse_Id(Long HouseId);
    Page<Image> findAll(Pageable pageable);
    List<Image> findAll(Specification<Image> specification);
}

