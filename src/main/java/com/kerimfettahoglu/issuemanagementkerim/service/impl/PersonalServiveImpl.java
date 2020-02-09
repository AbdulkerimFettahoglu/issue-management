package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.entity.Personal;
import com.kerimfettahoglu.issuemanagementkerim.repo.PersonalRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.PersonalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PersonalServiveImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    public PersonalServiveImpl(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public Personal save(Personal personal){
        return personalRepository.save(personal);
    }

    @Override
    public Personal getAPersonal(Long id) {
        return personalRepository.getOne(id);
    }

    @Override
    public Page<Personal> getIssuesByPage(Pageable pagable) {
        return personalRepository.findAll(pagable);
    }

    @Override
    public void delete(Personal personal) {
        personalRepository.delete(personal);
    }
}
