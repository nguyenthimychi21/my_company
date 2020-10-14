package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;

import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartment(Long id);

    void deleteDepartment(Department department);

    List<DepartmentDto> getAllDepartment();
}
