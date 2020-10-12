package com.example.demo.unit.serviceTest;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import com.example.demo.service.impl.CompanyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class CompanyServiceTest {
    @Autowired
    CompanyService companyService;
    @MockBean
    CompanyRepository companyRepository;

    @TestConfiguration
    static class BlockServiceImplTestConfiguration {
        @Bean
        public CompanyService companyService() {
            return new CompanyServiceImpl();
        }
    }

    Company company;
    Long id;
    List<String> list;

    @Before
    public void setUp() {
       company = new Company();
        Mockito.when(companyRepository.findAllById(company.getId())).thenReturn(company);
    }
@Test
    public void saveCompany() {
        companyRepository.save(company);
    }
@Test
    public void getCompany(){
        companyRepository.findAllById(id);
    }

@Test
    public void deleteCompany() {
        companyRepository.delete(company);
    }
@Test
    public void getAllCompany() {
         companyRepository.findAll();
    }
}
