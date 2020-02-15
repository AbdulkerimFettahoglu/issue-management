package com.kerimfettahoglu.issuemanagementkerim.api;

import com.kerimfettahoglu.issuemanagementkerim.dto.ProjectDto;
import com.kerimfettahoglu.issuemanagementkerim.entity.Project;
import com.kerimfettahoglu.issuemanagementkerim.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.getAProject(id));
    }

    @PostMapping()
    @RequestMapping("/post")
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    @PutMapping
    @RequestMapping("/put")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.updateProject(projectDto));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Long id) {
        boolean result = projectServiceImpl.delete(id);
        return ResponseEntity.ok(result);
    }
}