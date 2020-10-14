package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private Long departmentId;
    private String name;
    private Date birthday;
    private String gender;
    private int phone;
    private Long projectId;


}
