package com.example.demo.controller.request;

import com.example.demo.entity.Department;
import com.example.demo.entity.Domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyRequest {

    private Domain domain;

    private Set<Department> departments;

    @NotEmpty
    private String url;

    @Min(10)
    @NotNull
    private int phone;


}
