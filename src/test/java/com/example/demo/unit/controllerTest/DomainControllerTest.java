package com.example.demo.unit.controllerTest;


import com.example.demo.controller.DomainController;

import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.entity.Domain;
import com.example.demo.service.DomainService;


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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(DomainController.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
public class DomainControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DomainController domainController;
    @MockBean
    CreateDomainRequest createDomainRequest;
    @MockBean(name = "domainService")
    private DomainService domainService;
    private String body;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createDomain() throws Exception {

        Domain domain = new Domain();

        CreateDomainRequest createDomainRequest = new CreateDomainRequest();
        domain.setName(createDomainRequest.getName());
        body = ConverterUtils.convertObjectToJson(createDomainRequest);

        mockMvc.perform(post("/api/domain")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        domainService.saveDomain(domain);
    }

    @Test
    public void getAllDomain() throws Exception {


        mockMvc.perform(get("/api/domain")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        List<Domain> domains = domainService.getAllDomain();
    }

    @Test
    public void updateDomain() throws Exception {


    }

    @Test
    public void deleteAddressBook() throws Exception {

        mockMvc.perform(delete("/api/domain")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());

    }
}