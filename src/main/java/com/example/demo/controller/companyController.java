package com.example.demo.controller;


import com.example.demo.controller.request.CreateCompanyRequest;
import com.example.demo.controller.request.UpdateCompanyRequest;
import com.example.demo.entity.Company;

import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("api/company")
public class CompanyController {
    @Autowired
    DomainService domainServices;
    @Autowired
    CompanyService companyService;


    @RequestMapping(method = RequestMethod.POST)//create company
    public void createCompany(
            @RequestBody CreateCompanyRequest companyRequest
    ) {


        Domain domain = domainServices.getDomain(companyRequest.getDomain().getId());
        Company company = new Company();
        company.setDomain(companyRequest.getDomain());
        company.setUrl(companyRequest.getUrl());
        company.setPhone(companyRequest.getPhone());


        companyService.saveCompany(company);


    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT) //update company by id
    public void updateCompany(
            @PathVariable Long id,
            @RequestBody UpdateCompanyRequest companyRequest

    ) {

        Company company = companyService.getCompany(id);
        Domain domain = domainServices.getDomain(companyRequest.getDomainId());
        if (domain != null) {

            company.setPhone(companyRequest.getPhone());
            company.setUrl(companyRequest.getUrl());
            companyService.saveCompany(company);
        }

    }


    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE) //delete company by id
    public void deleteCompany(
            @PathVariable Long id

    ) {
        Company company = companyService.getCompany(id);
        companyService.deleteCompany(company);

    }

    @RequestMapping(method = RequestMethod.GET)// get all company
    public void getAllCompany(

    ) {
        List<Company> domains = companyService.getAllCompany();

    }
}
