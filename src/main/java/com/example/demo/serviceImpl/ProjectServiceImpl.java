package com.example.demo.serviceImpl;

import com.example.demo.entity.Project;

import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;


    public Project saveProject(Project project) {
        return  projectRepository.save(project);
    }

    public Project getProject(Long id) {
        return projectRepository.findAllById(id);
    }

    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    public List<Project> getAllProject() {
        return (List<Project>)projectRepository.findAll();
    }


}

