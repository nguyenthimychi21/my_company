package com.example.demo.unit.serviceTest;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
    @Autowired
    EmployeeService domainService;
    @MockBean
    EmployeeRepository employeeRepository;
    @MockBean
    ModelMapper modelMapper;

    @TestConfiguration
    static class BlockServiceImplTestConfiguration {
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    Employee employee;
    Long id;
    List<String> list;

    @Before
    public void setUp() {
        employee = new Employee();
        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(java.util.Optional.ofNullable(employee));
    }

    @Test
    public void saveEmployee() {
        employeeRepository.save(employee);
    }

    @Test
    public void getEmployee() {
        employeeRepository.findById(id);
    }

    @Test
    public void deleteEmployee() {
        employeeRepository.delete(employee);
    }

    @Test
    public void getAll() {
        employeeRepository.findAll();
    }
}
