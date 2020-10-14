package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domain_id")
    private Domain domain;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Department> departments;


}

