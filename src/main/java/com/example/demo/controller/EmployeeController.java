package com.example.demo.controller;

import com.example.demo.controller.request.CreateEmployeeRequest;
import com.example.demo.controller.request.UpdateEmployeeRequest;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    ModelMapper modelMapper;

    //create employee request
    @PostMapping()

    public ResponseEntity<String> createEmployee(
            @RequestBody CreateEmployeeRequest employeeRequest
    ) throws Exception {
        Department department = departmentService.getDepartment(employeeRequest.getDepartment().getId());
        Project project = new Project();

        if (department == null) {
            throw new Exception("Error 404 :Not Found");
        }
        {

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
            return new ResponseEntity<String>("Create Employee Success", HttpStatus.CREATED);

        }
    }

    //create employee dto
    @PostMapping(path = "/{dto}")

    public EmployeeDto createCompanyDto(
            @RequestBody EmployeeDto employeeDto
    ) throws Exception {


        Department department = departmentService.getDepartment(employeeDto.getDepartmentId());
        if (department == null) {
            throw new Exception("Error 404:Not Found");
        }
        {
            Employee employee = convertToEntity(employeeDto);
            Employee employeeCreated = employeeService.saveEmployee(employee);
            return convertToDto(employeeCreated);

        }

    }

    //convertToEntity
    private Employee convertToEntity(EmployeeDto employeeDto) throws ParseException {
        Employee employee = modelMapper.map(employeeDto, Employee.class);


        if (employeeDto.getDepartmentId() != null) {
            Employee employee1 = employeeService.getEmployee(employeeDto.getDepartmentId());

        }
        return employee;
    }

    //convertToDto
    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    //update employee by id
    @PutMapping(path = "/{id}")

    public ResponseEntity<String> updateEmployee(
            @PathVariable Long id,
            @RequestBody UpdateEmployeeRequest employeeRequest
    ) throws Exception {

        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new Exception("Error 404:Not Found");
        }
        employee.setName(employeeRequest.getName());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setGender(employeeRequest.getGender());
        employee.setPhone(employeeRequest.getPhone());
        employee.setProject(employeeRequest.getProjects());

        employeeService.saveEmployee(employee);
        return new ResponseEntity<String>("Update Employee Success", HttpStatus.CREATED);

    }

    //delete employee by id
    @DeleteMapping(path = "/{id}")

    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id
    ) throws Exception {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new Exception("Error 404:Not Found");
        }
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<String>("Delete Employee Success", HttpStatus.OK);

    }

    @GetMapping()//get all employee dto by id

    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAll();
    }

    //get employee dto by id

    @GetMapping(path = "/{id}")

    public EmployeeDto getEmployee(
            @PathVariable Long id
    ) {
        return convertToDto(employeeService.getEmployee(id));

    }


}
