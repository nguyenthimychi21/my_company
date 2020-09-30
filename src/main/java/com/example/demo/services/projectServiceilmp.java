package com.example.demo.services;

import com.example.demo.entity.project;
import com.example.demo.respository.projectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class projectServiceilmp implements projectServices {
    @Autowired
    projectRepository projectRepository;


    public project saveProject(project project) {
        return  projectRepository.save(project);
    }

    public project getProject(Long id) {
        return projectRepository.findByProjectId(id);
    }

    public void deleteProject(project project) {
        projectRepository.delete(project);
    }


}

