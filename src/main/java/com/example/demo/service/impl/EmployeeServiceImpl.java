package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        Optional<Employee> employeeResponse = employeeRepository.findById(id);
        Employee employee = employeeResponse.get();
        return employee;
        //return employeeRepository.findAllById(id);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public List<EmployeeDto> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(item -> employeeList.add(item));
        return employeeList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }


    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }


}
