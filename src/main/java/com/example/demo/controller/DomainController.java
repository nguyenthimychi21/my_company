package com.example.demo.controller;

import com.example.demo.controller.request.UpdateDomainRequest;
import com.example.demo.dto.DomainDto;
import com.example.demo.entity.Domain;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/domain")
public class DomainController {
    @Autowired
    DomainService domainServices;
    @Autowired
    CompanyService companyService;


    private Object List;
    private Object Domain;


    @PostMapping()//create domain

    public void createDomain(
            //  @RequestBody CreateDomainRequest domainRequest
            @RequestBody DomainDto domainDto

    ) {


        Domain domain = new Domain();
        domain.setName(domainDto.getName());
        domainServices.saveDomain(domain);
    }


    @GetMapping() //get all domain
    @ResponseBody
    public List<DomainDto> getAllDomain(

    ) {

        return domainServices.getAllDomain();

    }


    @PutMapping(path = "/{id}")//update domain by id

    public void updateDomain(
            @PathVariable Long id,
            @RequestBody UpdateDomainRequest domainRequest

    ) {
        Domain domain = domainServices.getDomain(id);
        domain.setName(domainRequest.getName());

        domainServices.saveDomain(domain);
    }

    @DeleteMapping(path = "/{id}")//delete domain by id

    public void deleteAddressBook(
            @PathVariable Long id

    ) {
        Domain domain = domainServices.getDomain(id);
        domainServices.deleteDomain(domain);

    }


}
