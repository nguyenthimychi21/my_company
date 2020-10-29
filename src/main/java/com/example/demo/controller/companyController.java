package com.example.demo.controller;


import com.example.demo.controller.request.CreateCompanyRequest;
import com.example.demo.controller.request.UpdateCompanyRequest;
import com.example.demo.controller.untils.ConverterUtils;
import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
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
import java.text.ParseException;
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
    @Autowired
    ModelMapper modelMapper;
    private ConverterUtils converterUtils;

    //create company request
    @PostMapping()

    public ResponseEntity<String> createCompany(
            @Validated @RequestBody CreateCompanyRequest createCompanyRequest
    ) throws Exception {


        Domain domain = domainServices.getDomain(createCompanyRequest.getDomain().getId());
        if (domain == null) {
            throw new Exception("Error 404:Not Found");
        }
        {
            Company company = new Company();
            company.setUrl(createCompanyRequest.getUrl());
            company.setPhone(createCompanyRequest.getPhone());
            company.setDomain(domain);
            companyService.saveCompany(company);
            return new ResponseEntity<String>("Create Company Success", HttpStatus.CREATED);

        }

    }


    @PostMapping(path = "/{dto}")

    public CompanyDto createCompanyDto(@Validated @RequestBody CompanyDto companyDto) throws ParseException {
        Domain domain = domainServices.getDomain(companyDto.getDomainId());
        {
            Company company = converterUtils.convertToEntity(companyDto);
            Company companyCreated = companyService.saveCompany(company);

            return converterUtils.convertToDto(companyCreated);
        }
    }


    //update company by id
    @PutMapping(path = "/{id}")

    public ResponseEntity<String> updateCompany(
            @PathVariable @Min(value = 1, message = "id must be greater than or equal to 1")
            @Max(value = 1000, message = "id must be lower than or equal to 1000") Long id,
            @Validated @RequestBody UpdateCompanyRequest companyRequest

    ) throws Exception {

        Company company = companyService.getCompany(id);
        if (company == null) {
            throw new Exception("Error 404:Not Found");
        }
        company.setPhone(companyRequest.getPhone());
        company.setUrl(companyRequest.getUrl());
        companyService.saveCompany(company);
        return new ResponseEntity<String>("Update Department Success", HttpStatus.CREATED);


    }

    //delete company by id
    @DeleteMapping(path = "/{id}")

    public ResponseEntity<String> deleteCompany(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id

    ) throws Exception {
        Company company = companyService.getCompany(id);
        if (company == null) {
            throw new Exception("Error 404:Not Found");
        }
        companyService.deleteCompany(company);
        return new ResponseEntity<String>("Delete Company Success", HttpStatus.OK);
    }

    //get company by id

    @GetMapping(path = "/{id}")

    public CompanyDto getCompany(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id
    ) {
        return converterUtils.convertToDto(companyService.getCompany(id));

    }

    // get all company
    @GetMapping()

    public List<CompanyDto> getAllCompany(

    ) {
        return companyService.getAllCompany();

    }

    //get  all phone
    @GetMapping(path = "/search")
    public List<CompanyDto> getAllPhone(
            @RequestParam(value = "phone") int phone


    ) {
        return companyService.getPhone(phone);
    }

    //get  all phone and url
    @GetMapping(path = "/search1")
    public List<CompanyDto> getAllPhoneandUrl(
            @RequestParam(value = "phone") int phone,
            @RequestParam(value = "url") String url


    ) {
        return companyService.getPhoneandUrl(phone, url);
    }

    //get all by url
    @GetMapping(path = "search_like")
    public List<CompanyDto> getAllByUrlLike(

            @RequestParam(value = "key_word") String keyWords


    ) {
        return companyService.getAllByUrlLike(keyWords);
    }
}
