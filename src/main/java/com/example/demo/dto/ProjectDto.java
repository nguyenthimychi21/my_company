package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String status;

    @NotEmpty
    private String descriptions;

    @NotNull
    private Long employeeId;


}
