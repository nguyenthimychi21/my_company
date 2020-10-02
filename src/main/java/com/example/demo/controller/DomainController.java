package com.example.demo.controller;

import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.controller.request.UpdateDomainRequest;
import com.example.demo.entity.Domain;

import com.example.demo.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/domain")
public class DomainController {
    @Autowired
    DomainService domainServices;

    @RequestMapping(method = RequestMethod.POST)
    public void createDomain(
            @RequestBody CreateDomainRequest domainRequest
    ) {

        Domain domain = new Domain();

        domain.setName(domainRequest.getName());
        domainServices.saveDomain(domain);
    }


    @RequestMapping(method = RequestMethod.GET)
    public void getAllDomain(

            ) {
        List<Domain> domains = domainServices.getAllDomain();

    }

    @RequestMapping(path ="/{id}",method = RequestMethod.PUT)
    public void updateDomain(
            @PathVariable Long id,
            @RequestBody UpdateDomainRequest domainRequest

    ){
        Domain domain = domainServices.getDomain(id);
        domain.setName(domainRequest.getName());

        domainServices.saveDomain(domain);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteAddressBook(
            @PathVariable Long id

    ) {
        Domain domain = domainServices.getDomain(id);
        domainServices.deleteDomain(domain);

    }
}
