package com.example.demo.service.impl;

import com.example.demo.dto.DomainDto;
import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import com.example.demo.service.DomainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    DomainRepository domainRepository;
    @Autowired
    ModelMapper modelMapper;

    public Domain saveDomain(Domain domain) {

        return domainRepository.save(domain);
    }

    public List<DomainDto> getAllDomain() {
        List<Domain> domainList = new ArrayList<>();
        Iterable<Domain> domains = domainRepository.findAll();
        domains.forEach(item -> domainList.add(item));
        return domainList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }


    private DomainDto convertToDto(Domain domain) {
        DomainDto domainDto = modelMapper.map(domain, DomainDto.class);
        return domainDto;
    }


    public Domain getDomain(Long id) {
        Optional<Domain> domainResponse = domainRepository.findById(id);
        Domain domain = domainResponse.get();
        return domain;


    }



    public void deleteDomain(Domain domain) {
        domainRepository.delete(domain);
    }


}
