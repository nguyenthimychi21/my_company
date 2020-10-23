package com.example.demo.controller.request;

import com.example.demo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    private String status;
    @NotEmpty
    private String descriptions;
    private Set<Employee> employees;


}
