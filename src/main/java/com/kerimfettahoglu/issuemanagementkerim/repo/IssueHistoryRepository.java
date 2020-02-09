package com.kerimfettahoglu.issuemanagementkerim.repo;

import com.kerimfettahoglu.issuemanagementkerim.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
