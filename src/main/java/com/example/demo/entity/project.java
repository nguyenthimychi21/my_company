package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "descriptions")
    private String descriptions;
    @ManyToMany
    private
    Set<Employee> employees;
    @ManyToMany(mappedBy = "projects")
    private
    Set<Employee> projects;


    public Project(String name, String status, String descriptions, Set<Employee> employees, Set<Employee> projects) {
        this.name = name;
        this.status = status;
        this.descriptions = descriptions;
        this.employees = employees;
        this.projects = projects;
    }

    public Project() {
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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

    public Set<Employee> getProjects() {
        return projects;
    }

    public void setProjects(Set<Employee> projects) {
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

