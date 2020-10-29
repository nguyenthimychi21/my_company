package com.example.demo.service.impl;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ModelMapper modelMapper;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProject(Long id) {
        Optional<Project> projectResponse = projectRepository.findById(id);
        Project project = projectResponse.get();
        return project;
        // return projectRepository.findAllById(id);
    }

    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    public List<ProjectDto> getAllProject() {
        List<Project> projectList = new ArrayList<>();
        Iterable<Project> projects = projectRepository.findAll();
        projects.forEach(item -> projectList.add(item));
        return projectList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }
    private ProjectDto convertToDto(Project project) {
        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        return projectDto;
    }
}

