package com.example.demo.controller;

import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.entity.Project;

import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)//create project
    public void createProject(
            @RequestBody CreateProjectRequest projectRequest
    ) {
        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());
        projectService.saveProject(project);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)//update project by id
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


    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)//delete project by id
    public void deleteProject(
            @PathVariable Long id

    ) {
        Project project = projectService.getProject(id);
        projectService.deleteProject(project);

    }

    @RequestMapping(method = RequestMethod.GET)//get all project
    public void getAllProject(

    ) {
        List<Project> projects = projectService.getAllProject();

    }
}
