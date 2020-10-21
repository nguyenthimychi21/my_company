package com.example.demo.controller;

import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.controller.request.UpdateDomainRequest;
import com.example.demo.dto.DomainDto;
import com.example.demo.entity.Domain;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DomainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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

    //create domain request
    @PostMapping()

    public ResponseEntity<String> createDomain(
            @RequestBody CreateDomainRequest domainRequest

    ) {

        Domain domain = new Domain();
        domain.setName(domainRequest.getName());
        domainServices.saveDomain(domain);
        return new ResponseEntity<String>("Create Domain Success", HttpStatus.OK);
    }

    //post domain dto
    @PostMapping(path = "/{dto}")

    public DomainDto createCompanyDto(
            @RequestBody DomainDto domainDto
    ) throws Exception {


        Domain domain = convertToEntity(domainDto);
        Domain domainCreate = domainServices.saveDomain(domain);
        return convertToDto(domainCreate);

    }

    //convertToEntity
    private Domain convertToEntity(DomainDto domainDto) throws ParseException {
        Domain domain = modelMapper.map(domainDto, Domain.class);


        if (domainDto.getId() != null) {
            Domain company1 = domainServices.getDomain(domainDto.getId());

        }
        return domain;
    }

    //convertToDto
    private DomainDto convertToDto(Domain domain) {
        DomainDto companyDto = modelMapper.map(domain, DomainDto.class);
        return companyDto;
    }

    //get domain by id
    @GetMapping(path = "/{id}")
    public DomainDto getDomain(
            @PathVariable Long id
    ) {
        return convertToDto(domainServices.getDomain(id));

    }

    //update domain by id
    @PutMapping(path = "/{id}")

    public ResponseEntity<String> updateDomain(
            @PathVariable Long id,
            @RequestBody UpdateDomainRequest domainRequest

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

    public ResponseEntity<String> deleteAddressBook(
            @PathVariable Long id

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
