package com.example.demo.controller.request;

import com.example.demo.entity.Company;

public class UpdateDepartmentRequest {
    private Long departmentId;

    private Company company;




    private Long companyId;

    private String name;

    private String descriptions;

    private String email;

    public UpdateDepartmentRequest(Long departmentId, Company company, Long companyId, String name, String descriptions, String email) {
        this.setDepartmentId(departmentId);
        this.setCompany(company);
        this.setCompanyId(companyId);
        this.setName(name);
        this.setDescriptions(descriptions);
        this.setEmail(email);
    }

    public UpdateDepartmentRequest() {
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
}
