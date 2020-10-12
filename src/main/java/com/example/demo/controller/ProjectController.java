package com.example.demo.controller;

import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.entity.Project;

import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping()//create project

    public void createProject(
            @RequestBody CreateProjectRequest projectRequest
    ) {

        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());


        projectService.saveProject(project);
    }

    @PutMapping(path = "/{id}")//update project by id

    public void updateDomain(
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
