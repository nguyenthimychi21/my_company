package com.example.demo.controller;

import com.example.demo.controller.request.CreateEmployeeRequest;
import com.example.demo.controller.request.UpdateEmployeeRequest;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping()//create employee

    public void createEmployee(
            @RequestBody CreateEmployeeRequest employeeRequest
    ) {
        Department department = departmentService.getDepartment(employeeRequest.getDepartment().getId());
        Project project = new Project();

        if (department != null) {

            Employee employee = new Employee();
            employee.setName(employeeRequest.getName());
            employee.setBirthday(employeeRequest.getBirthday());
            employee.setGender(employeeRequest.getGender());
            employee.setPhone(employeeRequest.getPhone());
            employee.setDepartment(department);
            project.setName("project1");
            project.setStatus("start");
            project.setDescriptions("des1");
            employee.getProject().add(project);
            employeeService.saveEmployee(employee);
        }
    }


    @PutMapping(path = "/{id}")//update employee by id

    public void updateEmployee(
            @PathVariable Long id,
            @RequestBody UpdateEmployeeRequest employeeRequest
    ) {

        Employee employee = employeeService.getEmployee(id);
        employee.setName(employeeRequest.getName());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setGender(employeeRequest.getGender());
        employee.setPhone(employeeRequest.getPhone());
        employee.setProject(employeeRequest.getProjects());

        employeeService.saveEmployee(employee);

    }

    @DeleteMapping(path = "/{id}")//delete employee by id

    public void deleteEmployee(
            @PathVariable Long id
    ) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);
    }

    @GetMapping()//get all employee by id

    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAll();
    }
}
