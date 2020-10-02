package com.example.demo.repository;

import com.example.demo.entity.Domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends CrudRepository<Domain,Long> {
    Domain findAllById(Long id);
}
