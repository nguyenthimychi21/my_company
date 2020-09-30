package com.example.demo.controller;

import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.controller.request.UpdateDomainRequest;
import com.example.demo.entity.domain;
import com.example.demo.services.domainServices;
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
    domainServices domainServices;

    @RequestMapping(method = RequestMethod.POST)
    public void createDomain(
            @RequestBody CreateDomainRequest domainRequest
    ) {

        domain domain = new domain();

        domain.setName(domainRequest.getName());
        domainServices.saveDomain(domain);
    }


    @RequestMapping(method = RequestMethod.GET)
    public void getAllDomain(

            ) {
        List<domain> domains = domainServices.getAllDomain();

    }
    @RequestMapping(path ="/{id}",method = RequestMethod.PUT)
    public void updateDomain(
            @PathVariable Long id,
            @RequestBody UpdateDomainRequest domainRequest

    ){
        domain domain = domainServices.getDomain(id);
        domain.setName(domainRequest.getName());

        domainServices.saveDomain(domain);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteAddressBook(
            @PathVariable Long id

    ) {
        domain domain = domainServices.getDomain(id);
        domainServices.deleteDomain(domain);

    }
}
