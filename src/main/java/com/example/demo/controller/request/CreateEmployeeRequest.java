package com.example.demo.controller.request;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private Department department;

    @NotEmpty
    private String name;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date birthday;

    @NotEmpty
    private String gender;

    @Min(10)
    @NotNull
    private int phone;

    private
    Set<Project> projects;


}
