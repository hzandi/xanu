package com.kurdestan.xanu.modules.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends
        PagingAndSortingRepository<Client, Long>,
        JpaSpecificationExecutor<Client> {

    Optional<Client> findByUsername(String username);
    Page<Client> findAll(Pageable pageable);
    List<Client> findAll(Specification<Client> specification);
}
