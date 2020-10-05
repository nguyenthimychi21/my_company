package com.example.demo.controller.request;

import com.example.demo.entity.Company;

import java.util.Set;

public class CreateDomainRequest {
    public CreateDomainRequest(Long id, String name, Set<Company> companies) {
        this.id = id;
        this.name = name;
        this.companies = companies;
    }

    private Long id;

    private String name;

    private Set<Company> companies;

    public CreateDomainRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
