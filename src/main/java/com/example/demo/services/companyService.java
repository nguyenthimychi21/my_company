package com.example.demo.services;

import com.example.demo.entity.company;

import java.util.List;

public interface companyService {
    company saveCompany(company company);
    company getCompany(Long id);
    void deleteCompany(company company);
    List<company> getAllCompany();
}
