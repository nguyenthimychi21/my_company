package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter

public class DomainDto implements Serializable {

    private Long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;


}
