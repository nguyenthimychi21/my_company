package com.example.demo.services;

import com.example.demo.entity.domain;

import java.util.List;

public interface domainServices {
    domain saveDomain(domain domain);
    List<domain> getAllDomain();
    domain getDomain(Long id);
    void deleteDomain(domain domain);
}
