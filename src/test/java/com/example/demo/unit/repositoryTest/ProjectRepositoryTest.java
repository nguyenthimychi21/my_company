package com.example.demo.unit.repositoryTest;


import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;

    private Project project1;
    private Project project2;

    @Before
    public void setUp() {
        // create data
        project1 = new Project(1L, "project1", "done", "des1", null);
        project2 = new Project(2L, "project2", "start", "des2", null);
        projectRepository.save(project1);
        projectRepository.save(project2);
    }

    @Test
    public void testFindAllProject() {
        List<Project> domains = (List<Project>) projectRepository.findAll();
        Assert.assertTrue(!domains.isEmpty());
    }

    @Test
    public void testDeleteProjectById() {
        Project project6 = new Project();
        Project project3 = projectRepository.save(project6);
        projectRepository.deleteById(project3.getId());
    }

    @Test
    public void createProject() {
        Project project = new Project(4L, "project4", "done", "des4", null);

        projectRepository.save(project);
    }

    @Test
    public void testFindProjectById() {
        Project project = new Project(4L, "project4", "done", "des4", null);
        projectRepository.findById(41L);
        Assert.assertNotNull(project);
    }
}
