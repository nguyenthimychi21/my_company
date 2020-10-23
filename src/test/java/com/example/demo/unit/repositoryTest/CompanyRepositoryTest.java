package com.example.demo.unit.repositoryTest;

import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyRepositoryTest {
    @Autowired
    DomainRepository domainRepository;

    private Domain domain1;
    private Domain domain2;
    Long id;

    @Before
    public void setUp() {
        // create data
        domain1 = new Domain();
        domain1.setId(1L);
        domain1.setName("ssss");
        domain2 = new Domain();
        domain2.setId(2L);
        domain2.setName("name2");
    }

    @Test
    public void getDomain() {
        domainRepository.findById(1L);
    }
}
