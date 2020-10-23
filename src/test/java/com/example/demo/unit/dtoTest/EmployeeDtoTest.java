package com.example.demo.unit.dtoTest;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class EmployeeDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertEmployeeEntityToEmployeeDto_thenCorrect() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("abc");
        Calendar cal = Calendar.getInstance();
        cal.set(1983, 0, 1);
        employee.setBirthday(cal.getTime());
        employee.setPhone(00);
        employee.setGender("nam");


        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        assertEquals(employee.getId(), employeeDto.getId());
        assertEquals(employee.getName(), employeeDto.getName());
        //   assertEquals(employeeDto.getBirthday(), employee.getBirthday());
        assertEquals(employee.getPhone(), employeeDto.getPhone());
        assertEquals(employee.getGender(), employeeDto.getGender());


    }

    @Test
    public void whenConvertEmployeeDtoToEmployeeEntity_thenCorrect() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("abc");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1983, 0, 1);

        employeeDto.setBirthday(cal1.getTime());
        employeeDto.setPhone(00);
        employeeDto.setGender("nam");

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        assertEquals(employeeDto.getId(), employee.getId());
        assertEquals(employeeDto.getName(), employee.getName());
        assertEquals(employeeDto.getBirthday(), employee.getBirthday());
        assertEquals(employeeDto.getPhone(), employee.getPhone());
        assertEquals(employeeDto.getGender(), employee.getGender());

    }
}
