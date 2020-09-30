package com.example.demo.entity;




import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Table(name = "domain")
@Entity
public class domain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="domain_id")
    private Long domainId;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "domain", fetch = FetchType.LAZY,
           cascade = CascadeType.ALL)
    private Set<company> companies;

    public domain(String name, Set<company> companies ) {
        this.name = name;
        this.companies = companies;
    }

    public domain() {
    }


    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<company> getCompanies() {
     return companies;
    }

    public void setCompanies(Set<company> companies) {
        this.companies = companies;
    }
}
