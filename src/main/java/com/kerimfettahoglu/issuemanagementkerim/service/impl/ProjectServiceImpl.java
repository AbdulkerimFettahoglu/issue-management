package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import com.kerimfettahoglu.issuemanagementkerim.repo.IssueHistoryRepository;
import com.kerimfettahoglu.issuemanagementkerim.repo.ProjectRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getAProject(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getIssuesByPage(Pageable pagable) {
        return projectRepository.findAll(pagable);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }
}
