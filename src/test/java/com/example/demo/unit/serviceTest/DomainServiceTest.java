package com.example.demo.unit.serviceTest;

import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import com.example.demo.service.DomainService;
import com.example.demo.service.impl.DomainServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class DomainServiceTest {
    @Autowired
    DomainService domainService;
    @MockBean
    DomainRepository domainRepository;
    @MockBean
    ModelMapper modelMapper;

    @TestConfiguration
    static class BlockServiceImplTestConfiguration {
        @Bean
        public DomainService userService() {
            return new DomainServiceImpl();
        }
    }

    Domain domain;
    Long id;
    List<String> list;


    @Before
    public void setUp() {
        domain = new Domain();


    }

    @Test
    public void deleteDomain() {
        domainRepository.delete(domain);
    }

    @Test
    public void getAllDomain() {
        domainRepository.findAll();
    }

    @Test
    public void getDomain() {
        domainRepository.findById(id);

    }

    @Test


    public void saveDomain() {

        domainRepository.save(domain);
    }
}
