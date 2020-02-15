package com.kerimfettahoglu.issuemanagementkerim.api;

import com.kerimfettahoglu.issuemanagementkerim.dto.IssueDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import com.kerimfettahoglu.issuemanagementkerim.service.impl.IssueServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/issue")
public class IssueControlller {
    private final IssueServiceImpl issueServiceImpl;

    public IssueControlller(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<IssueDto> getIssue(@PathVariable(name = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getAnIssue(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    @RequestMapping("/post")
    public ResponseEntity<IssueDto> saveIssue(@RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @PutMapping
    @RequestMapping("/put")
    public ResponseEntity<IssueDto> updateIssue(@RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.updateIssue(issueDto));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}