package com.example.demo.service.impl;

import com.example.demo.entity.Company;
import com.example.demo.entity.Domain;

import com.example.demo.repository.DomainRepository;
import com.example.demo.service.DomainService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomainServiceImpl implements DomainService {

 @Autowired
    DomainRepository domainRepository;

    public Domain saveDomain(Domain domain) {

        return domainRepository.save(domain)
                ;
    }

    public List<Domain> getAllDomain() {
        List<Domain> domainList = new ArrayList<>();
        Iterable<Domain> domains =  domainRepository.findAll();
        domains.forEach(item -> domainList.add(item));
        return domainList;
    }

    public Domain getDomain(Long id) {
        return domainRepository.findAllById(id);

    }


    public void deleteDomain(Domain domain) {
        domainRepository.delete(domain);
    }


}
