package com.kerimfettahoglu.issuemanagementkerim.dto;

import com.kerimfettahoglu.issuemanagementkerim.entity.IssueState;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueState issueState;
    private PersonalDto assignee;
    private ProjectDto project;
}
