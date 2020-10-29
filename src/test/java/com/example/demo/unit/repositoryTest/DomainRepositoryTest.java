package com.example.demo.unit.repositoryTest;

import com.example.demo.entity.Domain;
import com.example.demo.repository.DomainRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest


public class DomainRepositoryTest {

    @Autowired
    private DomainRepository domainRepository;

    private Domain domain1;
    private Domain domain2;

    @Before
    public void setUp() {
        // create data
        domain1 = new Domain(41L, "van", null);
        domain2 = new Domain(48L, "myname", null);
        domainRepository.save(domain1);
        domainRepository.save(domain2);
    }

    @Test
    public void testFindAllDomain() {
        List<Domain> domains = (List<Domain>) domainRepository.findAll();
        Assert.assertTrue(!domains.isEmpty());
    }

    @Test
    public void testDeleteDomainById() {
        Domain domain6 = new Domain(41L, "van", null);
        Domain domain3 = domainRepository.save(domain6);
        domainRepository.deleteById(domain3.getId());
    }

    @Test
    public void createDomain() {
        Domain domain = new Domain(41L, "van", null);

        domainRepository.save(domain);
    }

    @Test
    public void testFindDomainById() {
        Domain domain = new Domain(41L, "van", null);
        domainRepository.findById(41L);
        Assert.assertNotNull(domain);

    }
}