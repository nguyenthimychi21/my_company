package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class DomainDto implements Serializable {

    private Long id;
    private String name;


}
