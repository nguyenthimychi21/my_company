package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ModelMapper modelMapper;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        Optional<Department> departmentResponse = departmentRepository.findById(id);
        Department department = departmentResponse.get();
        return department;
        //  return departmentRepository.findAllById(id);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public List<DepartmentDto> getAllDepartment() {
        List<Department> departmentList = new ArrayList<>();
        Iterable<Department> departments = departmentRepository.findAll();
        departments.forEach(item -> departmentList.add(item));
        return departmentList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    private DepartmentDto convertToDto(Department department) {
        DepartmentDto domainDto = modelMapper.map(department, DepartmentDto.class);
        return domainDto;
    }


}
