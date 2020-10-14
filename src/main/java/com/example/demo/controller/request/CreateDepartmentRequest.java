package com.example.demo.controller.request;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentRequest {
    private Long departmentId;

    private Company company;



    private Long companyId;

    private String name;

    private String descriptions;

    private String email;


    private Set<Employee> employees;


}
