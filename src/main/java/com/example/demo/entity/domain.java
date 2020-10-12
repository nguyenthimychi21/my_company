package com.example.demo.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Table(name = "domain")
@Entity
public class Domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "domain",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)

    private Set<Company> companies;

    public Domain(String name, Set<Company> companies ) {
        this.name = name;
        this.companies = companies;
    }

    public Domain() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

