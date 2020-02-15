package com.kerimfettahoglu.issuemanagementkerim.api;

import com.kerimfettahoglu.issuemanagementkerim.entity.IssueHistory;
import com.kerimfettahoglu.issuemanagementkerim.service.impl.IssueHistoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issuehistory")
public class IssueHistoryController {
    private final IssueHistoryServiceImpl issueHistoryServiceImpl;

    public IssueHistoryController(IssueHistoryServiceImpl issueHistoryServiceImpl) {
        this.issueHistoryServiceImpl = issueHistoryServiceImpl;
    }

    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<IssueHistory> getIssueHistory(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueHistoryServiceImpl.getAnIssueHistoryItem(id));
    }

    @PostMapping
    @RequestMapping("/post")
    public ResponseEntity<IssueHistory> saveIssueHistory(@RequestBody IssueHistory issueHistory) {
        issueHistoryServiceImpl.save(issueHistory);
        return ResponseEntity.ok(issueHistory);
    }

    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity<IssueHistory> updateIssueHistory(@RequestBody IssueHistory issueHistory) {
        issueHistoryServiceImpl.save(issueHistory);
        return ResponseEntity.ok(issueHistory);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteIssueHistory(@PathVariable Long id) {
        return ResponseEntity.ok(issueHistoryServiceImpl.delete(id));
    }
}
