package com.example.demo.controller.request;

import com.example.demo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequest {
    //private Long projectId;

    private String name;

    private String status;

    private String descriptions;

    private Set<Employee> employees;


}
