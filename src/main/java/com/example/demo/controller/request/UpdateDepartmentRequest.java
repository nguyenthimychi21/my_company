package com.example.demo.controller.request;

import com.example.demo.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDepartmentRequest {
    private Long departmentId;

    private Company company;


    private Long companyId;

    private String name;

    private String descriptions;

    private String email;


}
