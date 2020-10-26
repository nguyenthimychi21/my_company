package com.example.demo.unit.controllerTest;


import com.example.demo.controller.DomainController;
import com.example.demo.controller.request.CreateDomainRequest;
import com.example.demo.controller.request.UpdateDomainRequest;
import com.example.demo.dto.DomainDto;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(DomainController.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
public class DomainControllerTest {


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
        CreateDomainRequest createDomainRequest = new CreateDomainRequest();
        createDomainRequest.setName("abc");
        Domain domain = new Domain();
        domain.setName(createDomainRequest.getName());
        body = ConverterUtils.convertObjectToJson(createDomainRequest);

        mockMvc.perform(post("/api/domain")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());

        domainService.saveDomain(domain);

    }

    @Test
    public void getAllDomain() throws Exception {


        mockMvc.perform(get("/api/domain")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        List<DomainDto> domains = domainService.getAllDomain();

    }

    @Test
    public void updateDomain() throws Exception {

        UpdateDomainRequest updateDomainRequest = new UpdateDomainRequest();
        Domain domain = domainService.getDomain(1l);
        updateDomainRequest.setName("abdc");
        body = ConverterUtils.convertObjectToJson(updateDomainRequest);
        mockMvc.perform(put("/api/domain/1")

                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());
    }

    @Test
    public void getDomain() throws Exception {

        mockMvc.perform(get("/api/domain/1")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
                .andDo(print());
        Domain domain = domainService.getDomain(1L);

    }

    @Test
    public void delete() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/domain/1")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))

                .andDo(print());
    }
}