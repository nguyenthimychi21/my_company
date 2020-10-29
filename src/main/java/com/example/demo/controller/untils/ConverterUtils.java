package com.example.demo.controller.untils;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.DomainDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;
import com.example.demo.entity.Domain;
import com.example.demo.entity.Employee;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DomainService;
import com.example.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class ConverterUtils {

    public  ModelMapper modelMapper;
    @Autowired
    CompanyService companyService;
    @Autowired
    DomainService domainService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    public Company convertToEntity(CompanyDto companyDto) {

        Company company = modelMapper.map(companyDto, Company.class);

        if (companyDto.getDomainId() != null) {
            Domain domain1 = domainService.getDomain(companyDto.getId());

        }
        return company;

    }
    //convertToDto

    public CompanyDto convertToDto(Company company) {
        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
        return companyDto;
    }


    //convertToDto
   public DomainDto convertDomainToDto(Domain domain) {
        DomainDto domainDto = modelMapper.map(domain, DomainDto.class);
        return domainDto;
    }

    //convertToEntity
    public Department convertDepartmentToEntity(DepartmentDto departmentDto) throws ParseException {
        Department department = modelMapper.map(departmentDto, Department.class);


        if (departmentDto.getCompanyId() != null) {
            Department department1 = departmentService.getDepartment(departmentDto.getCompanyId());

        }
        return department;
    }

    //convertToDto
    public DepartmentDto convertDepartmenToDto(Department department) {
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }


    //convertToEntity
    public Employee convertEmployeeToEntity(EmployeeDto employeeDto) throws ParseException {
        Employee employee = modelMapper.map(employeeDto, Employee.class);


        if (employeeDto.getDepartmentId() != null) {
            Employee employee1 = employeeService.getEmployee(employeeDto.getDepartmentId());

        }
        return employee;
    }

    //convertToDto
    public EmployeeDto convertEmployeeToDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }
}
