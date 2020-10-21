package com.example.demo.controller;

import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping()//create project request

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

    public ResponseEntity<String> updateProject(
            @PathVariable Long id,
            @RequestBody UpdateProjectRequest projectRequest

    ) throws Exception {

        Project project = projectService.getProject(id);
        if (project == null) {
            throw new Exception("Error 404:Not Found");
        }
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());

        projectService.saveProject(project);
        return new ResponseEntity<String>("Create Project Success", HttpStatus.CREATED);

    }


    @DeleteMapping(path = "/{id}")//delete project by id

    public ResponseEntity<String> deleteProject(
            @PathVariable Long id

    ) throws Exception {
        Project project = projectService.getProject(id);
        if (project == null) {
            throw new Exception("Error 404:Not Found");
        }
        projectService.deleteProject(project);
        return new ResponseEntity<String>("Delete Project Success", HttpStatus.OK);
    }

    //get all project
    @GetMapping()

    public List<Project> getAllProject(

    ) {
        return projectService.getAllProject();

    }

    //get project by id
    @GetMapping(path = "/{id}")

    public Project getProject(
            @PathVariable Long id
    ) {
        return projectService.getProject(id);

    }
}
