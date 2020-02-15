package com.kerimfettahoglu.issuemanagementkerim.service;

import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import com.kerimfettahoglu.issuemanagementkerim.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);
    IssueHistory  getAnIssueHistoryItem(Long id);
    Page<IssueHistory> getIssuesByPage(Pageable pagable);
    void delete(IssueHistory issueHistory);
    Boolean delete(Long id);
    IssueHistory updateIssueHistory(IssueHistory issueHistory);
}
