package com.example.demo.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyRequest {

    private Long companyId;

    private Long domainId;

    private String url;

    private int phone;


}
