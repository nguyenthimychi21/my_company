package com.example.demo.service;

import com.example.demo.entity.Project;


import java.util.List;

public interface ProjectService {
    Project saveProject(Project project);

    Project getProject(Long id);

    void deleteProject(Project project);

    List<Project> getAllProject();
}
