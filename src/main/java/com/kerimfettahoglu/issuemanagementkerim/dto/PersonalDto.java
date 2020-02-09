package com.kerimfettahoglu.issuemanagementkerim.dto;

import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import lombok.Data;

import java.util.List;

@Data
public class PersonalDto {
    private Long id;
    private String name;
    private String password;
    private String email;
}
