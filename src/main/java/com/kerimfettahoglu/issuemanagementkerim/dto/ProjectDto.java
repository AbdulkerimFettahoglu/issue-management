package com.kerimfettahoglu.issuemanagementkerim.dto;

import com.kerimfettahoglu.issuemanagementkerim.entity.Personal;
import lombok.Data;

@Data
public class ProjectDto {
    private Long id;
    private String projectName;
    private String projectCode;
    private PersonalDto manager;
}
