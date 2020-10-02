package com.example.demo.controller.request;

import com.example.demo.entity.Company;


public class CreateDepartmentRequest {
    private Long departmentId;

    private Company company;


    public CreateDepartmentRequest(Long companyId) {
        this.setCompanyId(companyId);
    }

    private Long companyId;

    private String name;

    private String descriptions;

    private String email;


    public CreateDepartmentRequest() {
    }

    public CreateDepartmentRequest(Long departmentId, Company company, String name, String descriptions, String email) {
        this.setDepartmentId(departmentId);
        this.setCompany(company);
        this.setName(name);
        this.setDescriptions(descriptions);
        this.setEmail(email);
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
