package com.example.demo.controller;

import com.example.demo.controller.request.CreateProjectRequest;
import com.example.demo.controller.request.UpdateProjectRequest;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping()//create project request

    public ResponseEntity<String> createProject(
            @Validated @RequestBody CreateProjectRequest projectRequest
    ) {
        Employee employee = new Employee();
        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());
        project.getEmployees().add(employee);

        projectService.saveProject(project);
        return new ResponseEntity<String>("Create Project Success", HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")//update project by id

    public ResponseEntity<String> updateProject(
            @PathVariable @Min(value = 1, message = "id must be greater than or equal to 1")
            @Max(value = 1000, message = "id must be lower than or equal to 1000") Long id,
            @Validated @RequestBody UpdateProjectRequest projectRequest

    ) throws Exception {

        Project project = projectService.getProject(id);
        if (project == null) {
            throw new Exception("Error 404:Not Found");
        }
        project.setName(projectRequest.getName());
        project.setStatus(projectRequest.getStatus());
        project.setDescriptions(projectRequest.getDescriptions());

        projectService.saveProject(project);
        return new ResponseEntity<String>("update Project Success", HttpStatus.CREATED);

    }


    @DeleteMapping(path = "/{id}")//delete project by id

    public ResponseEntity<String> deleteProject(
            @PathVariable @Min(value = 1, message = "id must be greater than or equal to 1")
            @Max(value = 1000, message = "id must be lower than or equal to 1000") Long id

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
            @PathVariable @Min(value = 1, message = "id must be greater than or equal to 1")
            @Max(value = 1000, message = "id must be lower than or equal to 1000") Long id
    ) {
        return projectService.getProject(id);

    }
}
