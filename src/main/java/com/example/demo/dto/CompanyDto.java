package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto {

    private Long id;

    @NotNull
    private Long domainId;

    @NotEmpty
    private String url;

    @NotNull
    @Min(10)
    private int phone;
}
