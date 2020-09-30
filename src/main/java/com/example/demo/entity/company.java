package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="company_id")
    private Long companyId;
    @Column(name="domain_id")
    private Long domainId;
    @Column(name="url")
    private String url;
    @Column(name="phone")
    private int phone;

    @ManyToOne
    private domain domain;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<department> departments;

    public company(Long domainId, String url, int phone, com.example.demo.entity.domain domain) {
        this.setDomainId(domainId);
        this.setUrl(url);
        this.setPhone(phone);
        this.setDomain(domain);
    }

    public company() {
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
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

    public com.example.demo.entity.domain getDomain() {
        return domain;
    }

    public void setDomain(com.example.demo.entity.domain domain) {
        this.domain = domain;
    }

    public Set<department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<department> departments) {
        this.departments = departments;
    }
}
