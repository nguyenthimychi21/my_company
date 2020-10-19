package com.example.demo.unit.serviceTest;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.impl.DepartmentServiceImpl;
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
public class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;
    @MockBean
    DepartmentRepository departmentRepository;
    @MockBean
    ModelMapper modelMapper;

    @TestConfiguration
    static class BlockServiceImplTestConfiguration {
        @Bean
        public DepartmentService departmentService() {
            return new DepartmentServiceImpl();
        }
    }

    Department department;
    Long id;
    List<String> list;

    @Before
    public void setUp() {
        department = new Department();
        Mockito.when(departmentRepository.findAllById(department.getId())).thenReturn(department);
    }

    @Test
    public void saveDepartment() {
        departmentRepository.save(department);
    }

    @Test
    public void getDepartment() {
        departmentRepository.findAllById(id);
    }

    @Test
    public void deleteDepartment() {
        departmentRepository.delete(department);
    }

    @Test
    public void getAllDepartment() {
        departmentRepository.findAll();
    }
}
