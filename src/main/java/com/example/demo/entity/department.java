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
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    private Company company;

    @Column(name = "name")
    private String name;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Employee> employees;


}
