package com.example.demo.services;

import com.example.demo.entity.domain;
import com.example.demo.respository.domainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceIlmt implements domainServices {
    @Autowired
    domainRepository domainRepository;

    public domain saveDomain(domain domain) {

        return domainRepository.save(domain)
                ;
    }

    public List<domain> getAllDomain() {
        return (List<domain>)domainRepository.findAll();
    }

    public domain getDomain(Long id) {
        return domainRepository.findByDomainId(id);
    }

    public void deleteDomain(domain domain) {
        domainRepository.delete(domain);
    }


}
