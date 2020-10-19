package com.example.demo.controller.request;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {
    private Long id;

    private Department department;

    private String name;

    private Date birthday;

    private String gender;

    private int phone;

    private
    Set<Project> projects;


}

