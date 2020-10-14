package com.example.demo.controller.request;


import com.example.demo.entity.Department;
import com.example.demo.entity.Domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyRequest {

    public CreateCompanyRequest(Domain domain) {
        this.setDomain(domain);
    }

    private Domain domain;

    public CreateCompanyRequest(Set<Department> departments) {
        this.setDepartments(departments);
    }

    private Set<Department> departments;

    private String url;

    private int phone;



}
