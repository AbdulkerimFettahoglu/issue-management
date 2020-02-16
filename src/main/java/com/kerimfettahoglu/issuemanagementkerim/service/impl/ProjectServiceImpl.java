package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.dto.ProjectDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import com.kerimfettahoglu.issuemanagementkerim.repo.ProjectRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.ProjectService;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
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
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public ProjectDto getAProject(Long id) {
        boolean isExist = projectRepository.existsById(id);
        if (isExist) {
            Project project = projectRepository.getOne(id);
            return modelMapper.map(project, ProjectDto.class);
        } else {
            throw new IllegalArgumentException("Project not found");
        }
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
    @Override
    public boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        Project project = modelMapper.map(projectDto, Project.class);
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);
    }
}
