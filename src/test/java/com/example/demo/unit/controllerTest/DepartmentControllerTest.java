package com.example.demo.unit.controllerTest;

import com.example.demo.controller.DepartmentController;
import com.example.demo.controller.request.CreateDepartmentRequest;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.unit.controllerTest.ConverterUtils;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DepartmentController domainController;
    @MockBean
    CreateDepartmentRequest createDomainRequest;
    @MockBean(name = "departmentService")
    private DepartmentService departmentService;
    private String body;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createDepartment() throws Exception {

        Department department = new Department();
        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
        department.setName(createDepartmentRequest.getName());
        department.setEmail(createDepartmentRequest.getEmail());
        department.setDescriptions(createDepartmentRequest.getDescriptions());

        body = ConverterUtils.convertObjectToJson(createDepartmentRequest);

        mockMvc.perform(post("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


        departmentService.saveDepartment(department);
    }

    @Test
    public void deleteDepartment() throws Exception {
        mockMvc.perform(delete("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());
    }

    @Test
    public void getAllDepartment() throws Exception {

        mockMvc.perform(get("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());

        List<Department> departments = departmentService.getAllDepartment();
    }

    @Test
    public void updateDepartment() throws Exception {
    }

}

