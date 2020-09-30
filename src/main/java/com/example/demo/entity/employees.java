package com.example.demo.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
public class employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employees_id")
    private Long employeesId;

    @ManyToOne
    private department department;
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
    Set<project> projects;

    public employees() {
    }


    @ManyToMany
    @JoinTable(
            name = "employees_project",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))




    public Set<project> getEmployeesProject() {
        return projects;
    }

    public void setEmployeesProject(Set<project> employeesProject) {
        this.projects = employeesProject;
    }

    public Long getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Long employeesId) {
        this.employeesId = employeesId;
    }

    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
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

    public Set<project> getProjects() {
        return projects;
    }

    public void setProjects(Set<project> projects) {
        this.projects = projects;
    }
}
