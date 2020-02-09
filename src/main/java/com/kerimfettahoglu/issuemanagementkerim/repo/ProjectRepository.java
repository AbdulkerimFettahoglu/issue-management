package com.kerimfettahoglu.issuemanagementkerim.repo;

import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
