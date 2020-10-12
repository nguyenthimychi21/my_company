package com.example.demo.controller.request;

import com.example.demo.entity.Employee;

import java.util.Set;

public class CreateProjectRequest {
    //private Long projectId;

    private String name;

    private String status;

    private String descriptions;

    public CreateProjectRequest(Set<Employee> employees) {
        this.setEmployees(employees);
    }

    private Set<Employee> employees;
    public CreateProjectRequest() {
    }

    public CreateProjectRequest(Long projectId, String name, String status, String descriptions) {

        this.name = name;
        this.status = status;
        this.descriptions = descriptions;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
