package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    private Department department;
    @Column(name="name")
    private String name;
    @Column(name="birthday")
    private Date birthday;
    @Column(name="gender")
    private String gender;
    @Column(name="phone")
    private int phone;
    @ManyToMany
    private
    Set<Project> projects;

    public Employee() {
    }


    @ManyToMany
    @JoinTable(
            name = "employees_project",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))




    public Set<Project> getEmployeesProject() {
        return projects;
    }

    public void setEmployeesProject(Set<Project> employeesProject) {
        this.projects = employeesProject;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

