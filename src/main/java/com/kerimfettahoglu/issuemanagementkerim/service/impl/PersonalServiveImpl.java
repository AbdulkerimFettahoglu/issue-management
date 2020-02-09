package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.dto.PersonalDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Personal;
import com.kerimfettahoglu.issuemanagementkerim.repo.PersonalRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.PersonalService;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonalServiveImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    private final ModelMapper modelMapper;

    public PersonalServiveImpl(PersonalRepository personalRepository, ModelMapper modelMapper) {
        this.personalRepository = personalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonalDto save(PersonalDto personalDto) {
        Personal personal = modelMapper.map(personalDto, Personal.class);
        personalRepository.save(personal);
        return modelMapper.map(personal, PersonalDto.class);
    }

    @Override
    public PersonalDto getAPersonal(Long id) {
        Personal personal = personalRepository.getOne(id);
        return modelMapper.map(personal, PersonalDto.class);
    }

    @Override
    public TPage<PersonalDto> getIssuesByPage(Pageable pagable) {
        Page<Personal> personalsFromDb = personalRepository.findAll(pagable);
        List<Personal> personalsList = personalsFromDb.getContent();
        TPage returnPage  = new TPage();
        returnPage.setStat(personalsFromDb, Arrays.asList(modelMapper.map(personalsList, PersonalDto[].class)));
        return returnPage;
    }

    @Override
    public void delete(PersonalDto personalDto) {
        personalRepository.delete(modelMapper.map(personalDto, Personal.class));
    }
}
