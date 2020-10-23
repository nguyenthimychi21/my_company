package com.example.demo.unit.dtoTest;

import com.example.demo.dto.DomainDto;
import com.example.demo.entity.Domain;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class DomainDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertDomainEntityToDomainDto_thenCorrect() {
        Domain domain = new Domain();
        domain.setId(1L);
        domain.setName("abc");


        DomainDto domainDto = modelMapper.map(domain, DomainDto.class);
        assertEquals(domain.getId(), domainDto.getId());
        assertEquals(domain.getName(), domainDto.getName());

    }

    @Test
    public void whenConvertDomainDtoToDomaintEntity_thenCorrect() {
        DomainDto domainDto = new DomainDto();
        domainDto.setId(1L);
        domainDto.setName("abc");

        Domain domain = modelMapper.map(domainDto, Domain.class);
        assertEquals(domainDto.getId(), domain.getId());
        assertEquals(domainDto.getName(), domain.getName());

    }
}
