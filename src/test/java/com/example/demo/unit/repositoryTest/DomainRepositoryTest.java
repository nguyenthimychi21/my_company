package com.example.demo.unit.repositoryTest;

import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
@AutoConfigureTestDatabase
@ContextConfiguration(classes = ObjectMapper.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class DomainRepositoryTest {
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