package com.example.demo.unit.controllerTest;

import com.example.demo.controller.DepartmentController;
import com.example.demo.controller.request.CreateDepartmentRequest;
import com.example.demo.controller.request.UpdateDepartmentRequest;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.unit.controllerTest.untilsTest.ConverterUtilsTest;
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
        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
        createDepartmentRequest.setName("abc");
        createDepartmentRequest.setEmail("fff@gmail.com");
        createDepartmentRequest.setDescriptions("des1");
        Department department = new Department();

        department.setName(createDepartmentRequest.getName());
        department.setEmail(createDepartmentRequest.getEmail());
        department.setDescriptions(createDepartmentRequest.getDescriptions());

        body = ConverterUtilsTest.convertObjectToJson(createDepartmentRequest);

        mockMvc.perform(post("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());


        departmentService.saveDepartment(department);
    }


    @Test
    public void deleteDepartment() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/department/1")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))

                .andDo(print());
    }

    @Test
    public void getAllDepartment() throws Exception {

        mockMvc.perform(get("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());

        List<DepartmentDto> departments = departmentService.getAllDepartment();
    }


    @Test
    public void updateDepartment() throws Exception {
        UpdateDepartmentRequest updateDepartmentRequest = new UpdateDepartmentRequest();
        updateDepartmentRequest.setName("abc");
        updateDepartmentRequest.setEmail("it@gmail.com");
        updateDepartmentRequest.setDescriptions("dd");
        body = ConverterUtilsTest.convertObjectToJson(updateDepartmentRequest);
        mockMvc.perform(put("/api/department/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());
    }

    //400
    @Test
    public void getDepartment() throws Exception {
        mockMvc.perform(get("/api/department/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());


    }
}

