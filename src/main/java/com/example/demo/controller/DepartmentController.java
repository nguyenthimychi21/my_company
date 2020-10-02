package com.example.demo.controller;

import com.example.demo.controller.request.UpdateDepartmentRequest;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;
import com.example.demo.controller.request.CreateDepartmentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CompanyService companyService;
    @RequestMapping(method = RequestMethod.POST)
    public  void createDepartment(

            @RequestBody CreateDepartmentRequest departmentRequest
    ){

           Department department = new Department();

           department.setName(departmentRequest.getName());
           department.setEmail(departmentRequest.getEmail());
           department.setDescriptions(departmentRequest.getDescriptions());
           departmentService.saveDepartment(department);

    }
    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public void deleteDepartment( @PathVariable Long id){
        Department department = departmentService.getDepartment(id);
        departmentService.deleteDepartment(department);

    }
@RequestMapping(method = RequestMethod.GET)
    public  void  getAllDepartment(){

    List<Department> departments=departmentService.getAllDepartment();

    }
    @RequestMapping(path = "/{id}",method = RequestMethod.PUT)
    public  void updateDepartment(
            @RequestBody UpdateDepartmentRequest departmentRequest,
            @PathVariable Long id
    ){
        Department department=departmentService.getDepartment(id);
        Company company =companyService.getCompany(departmentRequest.getCompanyId());
if(company !=null) {


    department.setName(departmentRequest.getName());
    department.setEmail(departmentRequest.getEmail());
    department.setDescriptions(departmentRequest.getEmail());
    departmentService.saveDepartment(department);
}

    }
}
