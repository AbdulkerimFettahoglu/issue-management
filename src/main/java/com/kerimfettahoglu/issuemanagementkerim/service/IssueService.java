package com.kerimfettahoglu.issuemanagementkerim.service;

import com.kerimfettahoglu.issuemanagementkerim.dto.IssueDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);
    IssueDto getAnIssue(Long id);
    TPage<IssueDto> getIssuesByPage(Pageable pagable);
    void delete(IssueDto issue);
}
