package com.example.demo.unit.serviceTest;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import com.example.demo.service.impl.ProjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ProjectServiceTest {
    @Autowired
    ProjectService companyService;
    @MockBean
    ProjectRepository projectRepository;

    @TestConfiguration
    static class BlockServiceImplTestConfiguration {
        @Bean
        public ProjectService projectService() {
            return new ProjectServiceImpl();
        }
    }

    Project project;
    Long id;
    List<String> list;

    @Before
    public void setUp() {
        project = new Project();
        Mockito.when(projectRepository.findAllById(project.getId())).thenReturn(project);
    }

    @Test
    public void saveProject() {
        projectRepository.save(project);
    }

    @Test
    public void getProject() {
        projectRepository.findAllById(id);
    }

    @Test
    public void deleteProject() {
        projectRepository.delete(project);
    }

    @Test
    public void getAllProject() {
        projectRepository.findAll()
        ;
    }
}

