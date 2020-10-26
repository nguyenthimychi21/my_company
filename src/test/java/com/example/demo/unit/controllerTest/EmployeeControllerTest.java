package com.example.demo.unit.controllerTest;

import com.example.demo.controller.EmployeeController;
import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.controller.request.CreateEmployeeRequest;
import com.example.demo.controller.request.UpdateEmployeeRequest;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    EmployeeController employeeController;
    @MockBean
    CreateDomainRequest createEmployeeRequest;
    @MockBean(name = "employeeService")
    private EmployeeService employeeService;
    private String body;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //400
    @Test
    public void createEmployee() throws Exception {

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setName("abc");
        //createEmployeeRequest.setBirthday("12/12/1998");
        createEmployeeRequest.setGender("nu");
        createEmployeeRequest.setPhone(0346);
        Employee employee = new Employee();

        employee.setName(createEmployeeRequest.getName());
        employee.setBirthday(createEmployeeRequest.getBirthday());
        employee.setGender(createEmployeeRequest.getGender());
        employee.setPhone(createEmployeeRequest.getPhone());
        body = ConverterUtils.convertObjectToJson(createEmployeeRequest);

        mockMvc.perform(post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());

        employeeService.saveEmployee(employee);
    }

    //400
    @Test
    public void updateEmployee() throws Exception {

        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest();

        updateEmployeeRequest.setName("abc");
        updateEmployeeRequest.setGender("nu");
        updateEmployeeRequest.setPhone(69);
        //updateEmployeeRequest.setBirthday(hhh);
        body = ConverterUtils.convertObjectToJson(updateEmployeeRequest);
        mockMvc.perform(put("/api/employee/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());
    }


    @Test
    public void deleteEmployee() throws Exception {


        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/employee/1")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))

                .andDo(print());
    }

    @Test
    public void getAllEmployee() throws Exception {
        mockMvc.perform(get("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());
        List<EmployeeDto> employees = employeeService.getAll();
    }

    //400
    @Test
    public void getEmployee() throws Exception {
        mockMvc.perform(get("/api/employee/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());


    }
}
