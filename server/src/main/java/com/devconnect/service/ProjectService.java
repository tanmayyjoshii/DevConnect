package com.devconnect.service;

import com.devconnect.model.Project;
import com.devconnect.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project submitProject(Project project) {
        // TODO: Implement validation and link to user
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(UUID id) {
        return projectRepository.findById(id);
    }

    public Project likeProject(UUID id, String userId) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            if (!project.getLikes().contains(userId)) {
                project.getLikes().add(userId);
                return projectRepository.save(project);
            }
            return project; // User already liked the project
        }
        return null; // Project not found
    }

    public Project commentOnProject(UUID id, String comment) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.getComments().add(comment);
            return projectRepository.save(project);
        }
        return null; // Project not found
    }
}