package com.example.demo.unit.controllerTest;

import com.example.demo.controller.ProjectController;
import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        CreateProjectRequest createProjectRequest = new CreateProjectRequest();
        createProjectRequest.setName("abc");
        createProjectRequest.setStatus("start");
        createProjectRequest.setDescriptions("des1");
        Project project = new Project();
        project.setName(createProjectRequest.getName());
        project.setStatus(createProjectRequest.getStatus());
        project.setDescriptions(createProjectRequest.getDescriptions());
        body = ConverterUtilsTest.convertObjectToJson(createProjectRequest);

        mockMvc.perform(post("/api/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());

        projectService.saveProject(project);
    }

    //400
    @Test
    public void updateProject() throws Exception {
        UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest();
        updateProjectRequest.setName("abcd");
        updateProjectRequest.setStatus("start");
        updateProjectRequest.setDescriptions("gg");
        body = ConverterUtilsTest.convertObjectToJson(updateProjectRequest);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/project/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print());
    }


    @Test
    public void deleteProject() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/project/1")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))

                .andDo(print());

    }


    @Test
    public void getAllProject() throws Exception {
        mockMvc.perform(get("/api/project")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //400
    @Test
    public void getProject() throws Exception {
        mockMvc.perform(get("/api/project/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print());
    }

}
