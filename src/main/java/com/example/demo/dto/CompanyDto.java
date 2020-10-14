package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto {

    private Long id;
    private Long domainId;
    private String url;
    private int phone;
}
