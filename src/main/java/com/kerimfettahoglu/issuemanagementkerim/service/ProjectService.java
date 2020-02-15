package com.kerimfettahoglu.issuemanagementkerim.service;

import com.kerimfettahoglu.issuemanagementkerim.dto.ProjectDto;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    ProjectDto save(ProjectDto projectDto);
    ProjectDto getAProject(Long id);
    TPage<ProjectDto> getIssuesByPage(Pageable pagable);
    void delete(ProjectDto projectDto);
    boolean delete(Long id);
    ProjectDto updateProject(ProjectDto projectDto);
}
