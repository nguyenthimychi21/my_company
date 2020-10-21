package com.example.demo.service.impl;

import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CompanyRepository companyRespository;

    public Company saveCompany(Company company) {
        return companyRespository.save(company);
    }

    public Company getCompany(Long id) {
        Optional<Company> companyResponse = companyRespository.findById(id);
        Company company = companyResponse.get();
        return company;
        //return companyRespository.findAllById(id);
    }


    public void deleteCompany(Company company) {
        companyRespository.delete(company);
    }

    @Override
    public List<CompanyDto> getPhone(int phone) {
        List<Company> companyList = new ArrayList<>();
        Iterable<Company> companies = companyRespository.findByPhone(phone);
        companies.forEach(item -> companyList.add(item));
        return companyList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CompanyDto> getPhoneandUrl(int phone, String url) {
        List<Company> companyList = new ArrayList<>();
        Iterable<Company> companies = companyRespository.findByPhoneAndUrl(phone,url);
        companies.forEach(item -> companyList.add(item));
        return companyList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CompanyDto> getAllByUrlLike(String keyWords) {
        List<Company> companyList = new ArrayList<>();
        Iterable<Company> companies = companyRespository.findByUrlLike('%'+keyWords+'%');
        companies.forEach(item -> companyList.add(item));
        return companyList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CompanyDto> getAllCompany() {
        List<Company> companyList = new ArrayList<>();
        Iterable<Company> companies = companyRespository.findAll();
        companies.forEach(item -> companyList.add(item));
        return companyList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        // return (List<Company>) companyRespository.findAll();
    }

    private CompanyDto convertToDto(Company company) {
        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
        return companyDto;
    }


}

