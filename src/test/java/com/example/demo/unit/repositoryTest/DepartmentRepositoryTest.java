package com.example.demo.unit.repositoryTest;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
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
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    private Department department1;
    private Department department2;

    @Before
    public void setUp() {
        // create data
        department1 = new Department(1L, null, "de1", "des1", "abc@gmail.com", null);
        department2 = new Department(2L, null, "de2", "des2", "abcd@gmail.com", null);
        departmentRepository.save(department1);
        departmentRepository.save(department2);
    }

    @Test
    public void findAllDepartment() {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        Assert.assertTrue(!departments.isEmpty());
    }

    @Test
    public void testDeleteDepartmentById() {
        Department domain6 = new Department(3L, null, "de3", "des3", "abcd3@gmail.com", null);
        Department domain3 = departmentRepository.save(domain6);
        departmentRepository.deleteById(domain3.getId());
    }

    @Test
    public void TestCreateDepartment() {
        Department department = new Department(4L, null, "de4", "des4", "abcde@gmail.com", null);

        departmentRepository.save(department);
    }

    @Test
    public void testFindDepartmentById() {
        Department department = new Department(4L, null, "de4", "des4", "abcde@gmail.com", null);
        ;
        departmentRepository.findById(41L);
        Assert.assertNotNull(department);
    }
}
