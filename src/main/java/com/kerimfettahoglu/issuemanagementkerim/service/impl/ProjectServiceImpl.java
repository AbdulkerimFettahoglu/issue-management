package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.dto.ProjectDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import com.kerimfettahoglu.issuemanagementkerim.repo.ProjectRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.ProjectService;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project project = modelMapper.map(projectDto, Project.class);
        projectRepository.save(project);
        return projectDto;
    }

    @Override
    public ProjectDto getAProject(Long id) {
        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public TPage<ProjectDto> getIssuesByPage(Pageable pagable) {
        Page<Project> projectsFromDd = projectRepository.findAll(pagable);
        List<Project> projectList = projectsFromDd.getContent();
        List<ProjectDto> projectDtoList = Arrays.asList(modelMapper.map(projectList, ProjectDto[].class));
        TPage returnPage = new TPage<ProjectDto>();
        returnPage.setStat(projectsFromDd,projectDtoList);
        return returnPage;
    }

    @Override
    public void delete(ProjectDto projectDto) {
        projectRepository.delete(modelMapper.map(projectDto, Project.class));
    }
}
