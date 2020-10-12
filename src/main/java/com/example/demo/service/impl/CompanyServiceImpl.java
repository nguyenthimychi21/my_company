package com.example.demo.service.impl;

import com.example.demo.entity.Company;

import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

   @Autowired
    CompanyRepository companyRespository;

    public Company saveCompany(Company company) {
        return companyRespository.save(company);
    }

    public Company getCompany(Long id) {
        return companyRespository.findAllById(id);
    }


    public void deleteCompany(Company company) {
        companyRespository.delete(company);
    }

    public List<Company> getAllCompany() {
        List<Company> companyList = new ArrayList<>();
        Iterable<Company> companies =  companyRespository.findAll();
        companies.forEach(item -> companyList.add(item));
        return companyList;
       // return (List<Company>) companyRespository.findAll();
    }


}

