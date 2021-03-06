package com.example.demo.controller.request;

import com.example.demo.entity.Company;
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
public class CreateDomainRequest {

    @NotEmpty
    private String name;

    private Set<Company> companies;

}
