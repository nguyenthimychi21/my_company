package com.example.demo.controller;


import com.example.demo.controller.request.CreateCompanyRequest;
import com.example.demo.controller.request.UpdateCompanyRequest;
import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {
    @Autowired
    DomainService domainServices;
    @Autowired
    CompanyService companyService;
    @Autowired
    DomainRepository domainRepository;

    @PostMapping()//create company

    public void createCompany(
            @RequestBody CreateCompanyRequest createCompanyRequest
    ) {


        Domain domain = domainServices.getDomain(createCompanyRequest.getDomain().getId());

        if (domain != null) {
            Company company = new Company();
            company.setUrl(createCompanyRequest.getUrl());
            company.setPhone(createCompanyRequest.getPhone());
            company.setDomain(domain);
            companyService.saveCompany(company);

        }

    }

    @PutMapping(path = "/{id}") //update company by id

    public void updateCompany(
            @PathVariable Long id,
            @RequestBody UpdateCompanyRequest companyRequest

    ) {

        Company company = companyService.getCompany(id);
        company.setPhone(companyRequest.getPhone());
        company.setUrl(companyRequest.getUrl());
        companyService.saveCompany(company);


    }


    @DeleteMapping(path = "/{id}") //delete company by id

    public void deleteCompany(
            @PathVariable Long id

    ) {
        Company company = companyService.getCompany(id);
        companyService.deleteCompany(company);

    }

    @GetMapping()// get all company

    public List<CompanyDto> getAllCompany(

    ) {
        return companyService.getAllCompany();

    }
}
