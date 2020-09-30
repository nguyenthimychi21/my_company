package com.example.demo.controller;

import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.controller.request.createProjectRequest;
import com.example.demo.entity.project;
import com.example.demo.services.projectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    projectServices projectService;
    @RequestMapping(method = RequestMethod.POST)
            public  void createProject(
                    @RequestBody createProjectRequest projectRequest
    ){
        project project =new project();
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());
        projectService.saveProject(project);
    }
    @RequestMapping(path ="/{id}",method = RequestMethod.PUT)
    public void updateDomain(
            @PathVariable Long id,
            @RequestBody UpdateProjectRequest projectRequest

    ){
        project project = projectService.getProject(id);
       project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
       project.setDescriptions(projectRequest.getDescriptions());
projectService.saveProject(project);


    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteProject(
            @PathVariable Long id

    ) {
        project project = projectService.getProject(id);
        projectService.deleteProject(project);

    }
}
