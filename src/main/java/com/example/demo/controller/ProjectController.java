package com.example.demo.controller;

import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping()//create project

    public void createProject(
            @RequestBody CreateProjectRequest projectRequest
    ) {
        Employee employee = new Employee();
        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());
        project.getEmployees().add(employee);

        projectService.saveProject(project);
    }

    @PutMapping(path = "/{id}")//update project by id

    public void updateProject(
            @PathVariable Long id,
            @RequestBody UpdateProjectRequest projectRequest

    ) {

        Project project = projectService.getProject(id);
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());

        projectService.saveProject(project);


    }


    @DeleteMapping(path = "/{id}")//delete project by id

    public void deleteProject(
            @PathVariable Long id

    ) {
        Project project = projectService.getProject(id);
        projectService.deleteProject(project);

    }

    @GetMapping()//get all project

    public List<Project> getAllProject(

    ) {
        return projectService.getAllProject();

    }
}
