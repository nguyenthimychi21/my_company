package com.example.demo.unit.controllerTest;

import com.example.demo.controller.CompanyController;
import com.example.demo.controller.request.CreateCompanyRequest;
import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;
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
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CompanyControllerTest companyControllerTest;
    @MockBean
    CreateCompanyRequest createCompanyRequest;
    @MockBean(name = "companyService")
    private CompanyService companyService;

    private String body;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createCompany() throws Exception {

        CreateCompanyRequest createCompanyRequest = new CreateCompanyRequest();

     //   createCompanyRequest.setPhone(098);
        createCompanyRequest.setUrl("ggg");
        Company company = new Company();

        company.setUrl(createCompanyRequest.getUrl());
        company.setPhone(createCompanyRequest.getPhone());


        body = ConverterUtils.convertObjectToJson(createCompanyRequest);

        mockMvc.perform(post("/api/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());


        companyService.saveCompany(company);

    }

    @Test
    public void updateCompany() throws Exception {
        mockMvc.perform(put("/api/domain")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());
    }

    @Test
    public void delete() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/company/id")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))

                .andDo(print());
    }


    @Test
    public void getAllCompany() throws Exception {
        mockMvc.perform(get("/api/company")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());

        List<CompanyDto> domains = companyService.getAllCompany();
    }
    @Test
    public void getDomain() throws Exception {
        mockMvc.perform(get("/api/company/id")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());


    }
}
