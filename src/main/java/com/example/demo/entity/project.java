package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "descriptions")
    private String descriptions;
    @ManyToMany
    private
    Set<employees> employees;
    @ManyToMany(mappedBy = "projects")
    private
    Set<employees> projects;


    public project(String name, String status, String descriptions, Set<com.example.demo.entity.employees> employees, Set<com.example.demo.entity.employees> projects) {
        this.name = name;
        this.status = status;
        this.descriptions = descriptions;
        this.employees = employees;
        this.projects = projects;
    }

    public project() {
    }

    public Set<com.example.demo.entity.employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<com.example.demo.entity.employees> employees) {
        this.employees = employees;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public Set<com.example.demo.entity.employees> getProjects() {
        return projects;
    }

    public void setProjects(Set<com.example.demo.entity.employees> projects) {
        this.projects = projects;
    }
}
