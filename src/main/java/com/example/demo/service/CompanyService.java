package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);

    Company getCompany(Long id);

    void deleteCompany(Company company);
    List<CompanyDto> getPhone(int phone);
    List<CompanyDto> getPhoneandUrl(int phone,String url);
    List<CompanyDto> getAllByUrlLike(String keyWords);
    List<CompanyDto> getAllCompany();
}
