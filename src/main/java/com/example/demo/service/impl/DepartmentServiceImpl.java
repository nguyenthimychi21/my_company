package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import com.example.demo.repository.DepartmentRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findAllById(id);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public List<Department> getAllDepartment() {
        List<Department> departmentList = new ArrayList<>();
        Iterable<Department> departments =  departmentRepository.findAll();
        departments.forEach(item -> departmentList.add(item));
        return departmentList;

    }


}
