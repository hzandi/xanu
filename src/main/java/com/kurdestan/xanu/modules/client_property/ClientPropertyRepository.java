package com.kurdestan.xanu.modules.client_property;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientPropertyRepository extends
        PagingAndSortingRepository<ClientProperty, Long>,
        JpaSpecificationExecutor<ClientProperty> {

    List<ClientProperty> findAllByClient_Id(Long clientId);
    List<ClientProperty> findAllByProperty_Id(Long propertyId);
    Page<ClientProperty> findAll(Pageable pageable);
    List<ClientProperty> findAll(Specification<ClientProperty> specification);
}
