package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Employee employee);

    List<Employee> getAll();
}
