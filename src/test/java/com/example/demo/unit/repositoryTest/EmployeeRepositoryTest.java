package com.example.demo.unit.repositoryTest;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
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
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee1;
    private Employee employee2;

    @Before
    public void setUp() {
        // create data
        employee1 = new Employee(1L, null, "name1", null, "nam", 03455, null);
        employee2 = new Employee(2L, null, "name2", null, "nnu", 03567, null);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    @Test
    public void findAllDepartment() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        Assert.assertTrue(!employees.isEmpty());
    }

    @Test
    public void testDeleteDepartmentById() {
        Employee employee6 = new Employee(3L, null, "name3", null, "nam", 0346, null);
        Employee employee3 = employeeRepository.save(employee6);
        employeeRepository.deleteById(employee3.getId());
    }

    @Test
    public void TestCreateEmployee() {
        Employee department = new Employee();

        employeeRepository.save(department);
    }

    @Test
    public void testFindDepartmentById() {
        Employee employee = new Employee(3L, null, "name3", null, "nam", 0346, null);
        ;
        employeeRepository.findById(41L);
        Assert.assertNotNull(employee);
    }
}
