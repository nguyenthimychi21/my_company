package com.example.demo.service;

import com.example.demo.dto.DomainDto;
import com.example.demo.entity.Domain;

import java.util.List;

public interface DomainService {
    Domain saveDomain(Domain domain);

    List<DomainDto> getAllDomain();

    Domain getDomain(Long id);

    void deleteDomain(Domain domain);
}
