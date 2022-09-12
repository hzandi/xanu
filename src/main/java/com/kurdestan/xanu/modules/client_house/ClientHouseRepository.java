package com.kurdestan.xanu.modules.client_house;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientHouseRepository extends
        PagingAndSortingRepository<ClientHouse, Long>,
        JpaSpecificationExecutor<ClientHouse> {

    List<ClientHouse> findAllByClient_Id(Long clientId);
    List<ClientHouse> findAllByHouse_Id(Long HouseId);
    Page<ClientHouse> findAll(Pageable pageable);
    List<ClientHouse> findAll(Specification<ClientHouse> specification);
}
