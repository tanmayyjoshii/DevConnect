package com.devconnect.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double stipend;

    @ElementCollection
    private List<String> stack;

    private String type;

    private String postedBy; // User ID of the poster

    @ElementCollection
    private List<String> applicants; // List of User IDs who applied

    // Constructors
    public Job() {
    }

    public Job(String title, String description, double stipend, List<String> stack, String type, String postedBy, List<String> applicants) {
        this.title = title;
        this.description = description;
        this.stipend = stipend;
        this.stack = stack;
        this.type = type;
        this.postedBy = postedBy;
        this.applicants = applicants;
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

    public double getStipend() {
        return stipend;
    }

    public void setStipend(double stipend) {
        this.stipend = stipend;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public List<String> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<String> applicants) {
        this.applicants = applicants;
    }
}