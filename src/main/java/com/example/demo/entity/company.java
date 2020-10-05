package com.example.demo.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;
    @Column(name = "phone")
    private int phone;

    @ManyToOne
    private Domain domain;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Department> departments;


    public Company() {
    }

    public Company(String url, int phone, Domain domain, Set<Department> departments) {

        this.setUrl(url);
        this.setPhone(phone);
        this.setDomain(domain);
        this.setDepartments(departments);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

