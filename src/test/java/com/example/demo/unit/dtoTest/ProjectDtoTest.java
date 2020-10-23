package com.example.demo.unit.dtoTest;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class ProjectDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertProjectEntityToProjectDto_thenCorrect() {
        Project project = new Project();
        project.setId(1L);
        project.setName("abc");
        project.setDescriptions("des1");
        project.setStatus("start");


        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        assertEquals(project.getId(), projectDto.getId());
        assertEquals(project.getName(), projectDto.getName());

        assertEquals(project.getDescriptions(), projectDto.getDescriptions());
        assertEquals(project.getStatus(), projectDto.getStatus());


    }

    @Test
    public void whenConvertProjectDtoToProjectEntity_thenCorrect() {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(1L);
        projectDto.setName("abc");


        projectDto.setDescriptions("des1");
        projectDto.setStatus("start");

        Project project = modelMapper.map(projectDto, Project.class);
        assertEquals(projectDto.getId(), project.getId());
        assertEquals(projectDto.getName(), project.getName());
        assertEquals(projectDto.getDescriptions(), project.getDescriptions());
        assertEquals(projectDto.getStatus(), project.getStatus());


    }
}

