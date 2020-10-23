package com.example.demo.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    @NotNull
    private Long id;
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "status must not be empty")
    private String status;
    @NotEmpty(message = "descriptions must not be empty")
    private String descriptions;
    @NotEmpty(message = "employeeId must not be empty")
    private Long employeeId;


}
