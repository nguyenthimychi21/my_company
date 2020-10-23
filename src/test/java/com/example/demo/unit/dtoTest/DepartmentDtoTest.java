package com.example.demo.unit.dtoTest;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class DepartmentDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertDepartmentEntityToDepartmentDto_thenCorrect() {
        Department department = new Department();
        department.setId(1L);
        department.setDescriptions("des1");
        department.setName("abc");
        department.setEmail("abc@gmail.com");


        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        assertEquals(department.getDescriptions(), departmentDto.getDescriptions());
        assertEquals(department.getName(), departmentDto.getName());
        assertEquals(department.getEmail(), departmentDto.getEmail());

    }

    @Test
    public void whenConvertDepartmentDtoToDepartmentEntity_thenCorrect() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(1L);
        departmentDto.setName("abc");
        departmentDto.setEmail("abc@gmail.com");

        Department department = modelMapper.map(departmentDto, Department.class);

        assertEquals(departmentDto.getDescriptions(), department.getDescriptions());
        assertEquals(departmentDto.getName(), department.getName());
        assertEquals(departmentDto.getEmail(), department.getEmail());

    }
}
