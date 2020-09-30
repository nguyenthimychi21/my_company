package com.example.demo.respository;

import com.example.demo.entity.domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface domainRepository extends CrudRepository<domain,Long> {
    domain findByDomainId(Long id);
}
