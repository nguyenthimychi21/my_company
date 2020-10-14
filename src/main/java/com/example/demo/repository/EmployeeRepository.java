package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findAllById(Long id);//find all id of employee
}
