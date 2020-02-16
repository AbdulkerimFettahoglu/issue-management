package com.kerimfettahoglu.issuemanagementkerim.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private Date date;
    private String text;
}
