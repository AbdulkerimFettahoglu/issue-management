package com.kerimfettahoglu.issuemanagementkerim.service;

import com.kerimfettahoglu.issuemanagementkerim.dto.PersonalDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.IssueHistory;
import com.kerimfettahoglu.issuemanagementkerim.entity.Personal;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonalService {
    PersonalDto save(PersonalDto personalDto);
    PersonalDto getAPersonal(Long id);
    TPage<PersonalDto> getIssuesByPage(Pageable pagable);
    void delete(PersonalDto personalDto);
    boolean delete(Long id);
    PersonalDto updatePersonal(PersonalDto personalDto);
}
