package com.example.demo.controller;

import com.example.demo.controller.request.CreateDepartmentRequest;
import com.example.demo.controller.request.UpdateDepartmentRequest;
import com.example.demo.controller.untils.ConverterUtils;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ModelMapper modelMapper;
    private ConverterUtils converterUtils;

    //create department request
    @PostMapping()

    public ResponseEntity<String> createDepartment(

            @Validated @RequestBody CreateDepartmentRequest departmentRequest
    ) throws Exception {
        Company company = companyService.getCompany(departmentRequest.getCompany().getId());
        if (company == null) {
            throw new Exception("Error 404 :Not Found");
        }
        {
            Department department = new Department();
            department.setName(departmentRequest.getName());
            department.setEmail(departmentRequest.getEmail());
            department.setDescriptions(departmentRequest.getDescriptions());
            department.setCompany(company);
            departmentService.saveDepartment(department);
            return new ResponseEntity<String>("Create Department Success", HttpStatus.CREATED);
        }

    }

    //create department dto
    @PostMapping(path = "/{dto}")

    public DepartmentDto createDepartment(
            @Validated @RequestBody DepartmentDto departmentDto
    ) throws Exception {


        Company company = companyService.getCompany(departmentDto.getCompanyId());
        if (company == null) {
            throw new Exception("Error 404:Not Found");
        }
        {
            Department department = converterUtils.convertDepartmentToEntity(departmentDto);
            Department departmnetCreated = departmentService.saveDepartment(department);
            return converterUtils.convertDepartmenToDto(departmnetCreated);

        }

    }

    //delete department by id
    @DeleteMapping(path = "/{id}")

    public ResponseEntity<String> deleteDepartment(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id) throws Exception {
        Department department = departmentService.getDepartment(id);
        if (department == null) {
            throw new Exception("Error 404:Not Found");
        }
        departmentService.deleteDepartment(department);
        return new ResponseEntity<String>("Delete Department Success", HttpStatus.CREATED);

    }

    //get all department
    @GetMapping()

    public List<DepartmentDto> getAllDepartment() {

        return departmentService.getAllDepartment();

    }

    //get department by id
    @GetMapping(path = "/{id}")

    public DepartmentDto getDepartment(
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id
    ) {
        return converterUtils.convertDepartmenToDto(departmentService.getDepartment(id));

    }

    @PutMapping(path = "/{id}")//update department by id

    public ResponseEntity<String> updateDepartment(
            @Validated @RequestBody UpdateDepartmentRequest departmentRequest,
            @PathVariable @Min(value = 1)
            @Max(value = 1000) Long id
    ) throws Exception {
        Department department = departmentService.getDepartment(id);
        if (department == null) {
            throw new Exception("Error 404:Not Found");
        }
        department.setName(departmentRequest.getName());
        department.setEmail(departmentRequest.getEmail());
        department.setDescriptions(departmentRequest.getEmail());
        departmentService.saveDepartment(department);

        return new ResponseEntity<String>("Update Department Success", HttpStatus.CREATED);
    }
}
