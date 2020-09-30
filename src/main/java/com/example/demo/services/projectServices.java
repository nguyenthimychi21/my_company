package com.example.demo.services;

import com.example.demo.entity.project;

public interface projectServices {
    project saveProject(project project);
    project getProject(Long id);
  void  deleteProject(project project);
}
