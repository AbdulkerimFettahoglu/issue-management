package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.entity.IssueHistory;
import com.kerimfettahoglu.issuemanagementkerim.repo.IssueHistoryRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class IssueHistoryServiceImpl implements IssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;
    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory){
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getAnIssueHistoryItem(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getIssuesByPage(Pageable pagable) {
        return issueHistoryRepository.findAll(pagable);
    }

    @Override
    public void delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
    }
}
