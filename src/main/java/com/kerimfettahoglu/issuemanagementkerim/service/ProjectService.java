package com.kerimfettahoglu.issuemanagementkerim.service;

import com.kerimfettahoglu.issuemanagementkerim.entity.Personal;
import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Project save(Project project);
    Project  getAProject(Long id);
    Page<Project> getIssuesByPage(Pageable pagable);
    void delete(Project project);
}
