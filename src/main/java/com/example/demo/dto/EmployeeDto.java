package com.example.demo.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @NotNull
    private Long id;
    @NotEmpty(message = "departmentId must not be empty")
    private Long departmentId;
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "birthday must not be empty")
    private Date birthday;
    @NotEmpty(message = "gender must not be empty")
    private String gender;
    @NotEmpty(message = "phone must not be empty")
    private int phone;
    @NotEmpty(message = "projectId must not be empty")
    private Long projectId;


    public void setBirthday(Date s) {
    }
}
