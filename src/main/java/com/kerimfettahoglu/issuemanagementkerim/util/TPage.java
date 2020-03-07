package com.kerimfettahoglu.issuemanagementkerim.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage<returnType> {
    private int number;
    private int size;
    private Sort sort;
    private int totalPages;
    private Long totalElements;
    private List<returnType> content;

    public void setStat(Page page, List<returnType> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }
}
