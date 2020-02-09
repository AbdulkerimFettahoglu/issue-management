package com.kerimfettahoglu.issuemanagementkerim.service;

import com.kerimfettahoglu.issuemanagementkerim.entity.IssueHistory;
import com.kerimfettahoglu.issuemanagementkerim.entity.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonalService {
    Personal save(Personal personal);
    Personal  getAPersonal(Long id);
    Page<Personal> getIssuesByPage(Pageable pagable);
    void delete(Personal personal);
}
