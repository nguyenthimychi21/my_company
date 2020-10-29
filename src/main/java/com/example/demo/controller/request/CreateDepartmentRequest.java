package com.example.demo.controller.request;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentRequest {

    private Company company;

    @NotEmpty
    private String name;

    @NotEmpty
    private String descriptions;

    @NotEmpty
    @Email
    private String email;

    private Set<Employee> employees;


}
