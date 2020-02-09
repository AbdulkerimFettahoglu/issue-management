package com.kerimfettahoglu.issuemanagementkerim.service.impl;

import com.kerimfettahoglu.issuemanagementkerim.dto.IssueDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import com.kerimfettahoglu.issuemanagementkerim.repo.IssueRepository;
import com.kerimfettahoglu.issuemanagementkerim.service.IssueService;
import com.kerimfettahoglu.issuemanagementkerim.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {
        Issue issue = modelMapper.map(issueDto, Issue.class);
        issueRepository.save(issue);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public IssueDto getAnIssue(Long id) {
        Issue issue = issueRepository.getOne(id);
        IssueDto issueDtoReturn = modelMapper.map(issue, IssueDto.class);
        return issueDtoReturn;
    }

    @Override
    public TPage<IssueDto> getIssuesByPage(Pageable pagable) {
        Page<Issue> issuesFromDB = issueRepository.findAll(pagable);
        List<Issue> issuesFromDBList = issuesFromDB.getContent();
        List<IssueDto> issuesDto = Arrays.asList(modelMapper.map(issuesFromDB, IssueDto[].class));
        TPage<IssueDto> returnPage = new TPage();
        returnPage.setStat(issuesFromDB, issuesDto);
        return returnPage;
    }

    @Override
    public void delete(IssueDto issueDto) {
        Issue issue = modelMapper.map(issueDto, Issue.class);
        issueRepository.delete(issue);
    }
}