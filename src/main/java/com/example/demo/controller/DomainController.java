package com.example.demo.controller;

import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.controller.request.UpdateDomainRequest;
import com.example.demo.controller.untils.ConverterUtils;
import com.example.demo.dto.DomainDto;
import com.example.demo.entity.Domain;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DomainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/domain")

public class DomainController {
    @Autowired
    DomainService domainServices;
    @Autowired
    CompanyService companyService;

    @Autowired
    ModelMapper modelMapper;
    private Object List;
    private Object Domain;

    private ConverterUtils converterUtils;

    //create domain request
    @PostMapping()

    public ResponseEntity<String> createDomain(
            @Validated @RequestBody CreateDomainRequest domainRequest

    ) {

        Domain domain = new Domain();
        domain.setName(domainRequest.getName());
        domainServices.saveDomain(domain);
        return new ResponseEntity<String>("Create Domain Success", HttpStatus.OK);
    }


    //get domain by id
    @GetMapping(path = "/{id}")
    public DomainDto getDomain(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id) {
        return converterUtils.convertDomainToDto(domainServices.getDomain(id));

    }


    //update domain by id
    @PutMapping(path = "/{id}")

    public ResponseEntity<String> updateDomain(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id,
            @Validated @RequestBody UpdateDomainRequest domainRequest

    ) throws Exception {
        Domain domain = domainServices.getDomain(id);
        if (domain == null) {
            throw new Exception("Error 404:Not Found");
        }
        domain.setName(domainRequest.getName());

        domainServices.saveDomain(domain);
        return new ResponseEntity<String>("Delete Domain Success", HttpStatus.OK);
    }

    //delete domain by id
    @DeleteMapping(path = "/{id}")

    public ResponseEntity<String> deleteDomain(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id

    ) throws Exception {
        Domain domain = domainServices.getDomain(id);
        if (domain == null) {
            throw new Exception("Error 404:Not Found");
        }
        domainServices.deleteDomain(domain);
        return new ResponseEntity<String>("Delete Domain Success", HttpStatus.OK);
    }

    //get all domain
    @GetMapping()

    public java.util.List<DomainDto> getAllDomain(

    ) {
        return domainServices.getAllDomain();

    }

}
