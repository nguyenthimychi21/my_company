package com.example.demo.controller.request;


import com.example.demo.entity.Department;
import com.example.demo.entity.Domain;

import java.util.Set;

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


    public CreateCompanyRequest(Long companyId, String url, int phone) {


        this.setUrl(url);
        this.setPhone(phone);
    }

    public CreateCompanyRequest() {
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
