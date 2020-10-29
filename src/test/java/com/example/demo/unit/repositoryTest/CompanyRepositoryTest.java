package com.example.demo.unit.repositoryTest;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
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
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    private Company company1;
    private Company company2;

    @Before
    public void setUp() {
        // create data
        company1 = new Company(1L, "hhh", 03466666, null, null);
        company2 = new Company(1L, "hhh", 03466666, null, null);
        companyRepository.save(company1);
        companyRepository.save(company2);
    }

    @Test
    public void findAllCompany() {
        List<Company> companies = (List<Company>) companyRepository.findAll();
        Assert.assertTrue(!companies.isEmpty());
    }

    @Test
    public void testDeletById() {
        Company domain6 = new Company(11L, "hhh", 03466666, null, null);
        Company domain3 = companyRepository.save(domain6);
        companyRepository.deleteById(domain3.getId());
    }

    @Test
    public void TestCreateCompany() {
        Company company = new Company(11L, "abc.z", 03476666, null, null);

        companyRepository.save(company);
    }

    @Test
    public void testFindById() {
        Company company = new Company(1L, "hhh", 03466666, null, null);
        companyRepository.findById(41L);
        Assert.assertNotNull(company);

    }

    @Test
    public void testFindByPhone() {
        Company company = new Company(1L, "hhh", 03466666, null, null);
        companyRepository.findByPhone(03466666);
        Assert.assertNotNull(company);

    }

    @Test
    public void testFindByPhoneAndUrl() {
        Company company = new Company(1L, "hhh", 03466666, null, null);
        companyRepository.findByPhoneAndUrl(03466666, "hhh");
        Assert.assertNotNull(company);

    }

}
