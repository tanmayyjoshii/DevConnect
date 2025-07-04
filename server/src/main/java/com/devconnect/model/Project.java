package com.devconnect.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    private List<String> techUsed;
    private String githubLink;
    private String submittedBy; // User ID of the submitter

    @ElementCollection
    private List<String> likes; // List of User IDs who liked the project

    @ElementCollection
    private List<String> comments; // List of comments

    // Constructors
    public Project() {
    }

    public Project(String title, String description, List<String> techUsed, String githubLink, String submittedBy) {
        this.title = title;
        this.description = description;
        this.techUsed = techUsed;
        this.githubLink = githubLink;
        this.submittedBy = submittedBy;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTechUsed() {
        return techUsed;
    }

    public void setTechUsed(List<String> techUsed) {
        this.techUsed = techUsed;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}