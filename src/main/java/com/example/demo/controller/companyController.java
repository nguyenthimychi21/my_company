package com.example.demo.controller;


import com.example.demo.controller.request.CreateCompanyRequest;
import com.example.demo.entity.company;
import com.example.demo.entity.domain;
import com.example.demo.services.companyService;
import com.example.demo.services.domainServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/company")
public class companyController {
    @Autowired
    domainServices domainServices;
    @Autowired
    companyService companyService;


    @RequestMapping(method = RequestMethod.POST)//error
    public void createDomain(
            @RequestBody CreateCompanyRequest companyRequest
    ) {

        domain domain = domainServices.getDomain(companyRequest.getDomainId());
       if(domain!=null) {
           company company = new company();
           company.setDomainId(companyRequest.getDomainId());
           company.setUrl(companyRequest.getUrl());
           company.setPhone(companyRequest.getPhone());
           companyService.saveCompany(company);

       }
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(
            @PathVariable Long id

    ) {
        company company = companyService.getCompany(id);
        companyService.deleteCompany(company);

    }

    @RequestMapping(method = RequestMethod.GET)
    public void getAllCompany(

    ) {
        List<company> domains = companyService.getAllCompany();

    }
}
