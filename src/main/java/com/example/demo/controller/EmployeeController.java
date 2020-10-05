package com.example.demo.controller;

import com.example.demo.controller.request.CreateEmployeeRequest;
import com.example.demo.controller.request.UpdateEmployeeRequest;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.POST)//create employee
    public void createEmployee(
            @RequestBody CreateEmployeeRequest employeeRequest
    ) {

        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setGender(employeeRequest.getGender());
        employee.setPhone(employeeRequest.getPhone());
        employeeService.saveEmployee(employee);

    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)//update employee by id
    public void updateEmployee(
            @PathVariable Long id,
            @RequestBody UpdateEmployeeRequest employeeRequest
    ) {
        Employee employee = employeeService.getEmployee(id);
        employee.setName(employeeRequest.getName());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setGender(employeeRequest.getGender());
        employee.setPhone(employeeRequest.getPhone());
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)//delete employee by id
    public void deleteEmployee(
            @PathVariable Long id
    ) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET)//get all employee by id
    public void getAllEmployee() {
        List<Employee> employees = employeeService.getAll();
    }
}
