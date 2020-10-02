package com.example.demo.controller;

import com.example.demo.controller.request.CreateEmployeeRequest;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping(method = RequestMethod.POST)
    public void CreateEmployee(
            @RequestBody CreateEmployeeRequest employeeRequest
    ){

        Employee employee =new Employee();


    }
}
