package com.example.demo.service;

import com.example.demo.entity.Company;


import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);

    Company getCompany(Long id);

    void deleteCompany(Company company);

    List<Company> getAllCompany();
}