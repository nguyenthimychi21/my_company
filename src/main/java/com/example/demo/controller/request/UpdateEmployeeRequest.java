package com.example.demo.controller.request;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;

import java.util.Date;
import java.util.Set;

public class UpdateEmployeeRequest {
    private Long id;


    private Department department;

    private String name;

    private Date birthday;

    private String gender;

    private int phone;

    private
    Set<Project> projects;

    public UpdateEmployeeRequest() {
    }

    public UpdateEmployeeRequest(Long id, Department department, String name, Date birthday, String gender, int phone, Set<Project> projects) {
        this.setId(id);
        this.setDepartment(department);
        this.setName(name);
        this.setBirthday(birthday);
        this.setGender(gender);
        this.setPhone(phone);
        this.setProjects(projects);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

