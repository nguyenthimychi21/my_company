package com.example.demo.unit.dtoTest;

import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class CompanyDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertCompanyEntityToCompanytDto_thenCorrect() {
        Company company = new Company();
        company.setId(1L);
        company.setPhone(0344);
        company.setUrl("abc.com");


        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

        assertEquals(company.getPhone(), companyDto.getPhone());
        assertEquals(company.getUrl(), companyDto.getUrl());

    }

    @Test
    public void whenConvertCompanyDtoToCompanyEntity_thenCorrect() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setPhone(0346);
        companyDto.setUrl("abc.com");

        Company company = modelMapper.map(companyDto, Company.class);

        assertEquals(companyDto.getPhone(), company.getPhone());
        assertEquals(companyDto.getUrl(), company.getUrl());

    }
}
