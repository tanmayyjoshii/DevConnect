package com.devconnect.controller;

import com.devconnect.model.Project;
import com.devconnect.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> submitProject(@RequestBody Project project) {
        Project submittedProject = projectService.submitProject(project);
        return ResponseEntity.ok(submittedProject);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable UUID id) {
        Project project = projectService.getProjectById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/like/{id}")
    public ResponseEntity<Void> likeProject(@PathVariable UUID id) {
        projectService.likeProject(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/comment/{id}")
    public ResponseEntity<Void> commentOnProject(@PathVariable UUID id, @RequestBody String comment) {
        projectService.commentOnProject(id, comment);
        return ResponseEntity.ok().build();
    }
}