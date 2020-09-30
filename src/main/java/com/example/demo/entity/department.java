package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @ManyToOne
    private company company;

    @Column(name="name")
    private String name;
    @Column(name="descriptions")
    private String descriptions;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<employees> employees;

    public department(company company, String name, String descriptions, String email, Set<com.example.demo.entity.employees> employees) {
        this.company = company;
        this.name = name;
        this.descriptions = descriptions;
        this.email = email;
        this.employees = employees;
    }

    public department() {
    }


    public Set<com.example.demo.entity.employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<com.example.demo.entity.employees> employees) {
        this.employees = employees;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public company getCompany() {
        return company;
    }

    public void setCompany(company company) {
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
}
