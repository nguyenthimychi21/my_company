package com.example.demo.controller;

import com.example.demo.controller.request.UpdateDepartmentRequest;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;
import com.example.demo.controller.request.CreateDepartmentRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CompanyService companyService;

    @PostMapping()//create department
    @Test
    public void createDepartment(

            @RequestBody CreateDepartmentRequest departmentRequest
    ) {
        Company company = companyService.getCompany(departmentRequest.getCompany().getId());
        if (company != null) {
            Department department = new Department();
            department.setName(departmentRequest.getName());
            department.setEmail(departmentRequest.getEmail());
            department.setDescriptions(departmentRequest.getDescriptions());
            department.setCompany(company);
            departmentService.saveDepartment(department);
        }
    }

    @DeleteMapping(path = "/{id}")//delete department by id

    public void deleteDepartment(@PathVariable Long id) {
        Department department = departmentService.getDepartment(id);
        departmentService.deleteDepartment(department);

    }

    @GetMapping()//get all department

    public List<Department> getAllDepartment() {

        return departmentService.getAllDepartment();

    }

    @PutMapping(path = "/{id}")//update department by id

    public void updateDepartment(
            @RequestBody UpdateDepartmentRequest departmentRequest,
            @PathVariable Long id
    ) {
        Department department = departmentService.getDepartment(id);


        department.setName(departmentRequest.getName());
        department.setEmail(departmentRequest.getEmail());
        department.setDescriptions(departmentRequest.getEmail());
        departmentService.saveDepartment(department);


    }
}
