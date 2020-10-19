package com.example.demo.unit.controllerTest;

import com.example.demo.controller.ProjectController;
import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ProjectController projectController;
    @MockBean
    CreateProjectRequest createProjectRequest;
    @MockBean(name = "projectService")
    private ProjectService projectService;
    private String body;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createProject() throws Exception {
        Project project = new Project();
        CreateProjectRequest createProjectRequest = new CreateProjectRequest();
        project.setName(createProjectRequest.getName());
        project.setStatus(createProjectRequest.getStatus());
        project.setDescriptions(createProjectRequest.getDescriptions());
        body = ConverterUtils.convertObjectToJson(createProjectRequest);

        mockMvc.perform(post("/api/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        projectService.saveProject(project);
    }

    @Test
    public void updateDomain() throws Exception {
    }

    @Test
    public void deleteProject() throws Exception {


    }

    @Test
    public void getAllProject() throws Exception {
        mockMvc.perform(get("/api/project")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
