package com.kerimfettahoglu.issuemanagementkerim.repo;

import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
