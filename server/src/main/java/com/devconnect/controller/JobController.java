package com.devconnect.controller;

import com.devconnect.model.Job;
import com.devconnect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(@RequestParam(required = false) List<String> stack,
                                              @RequestParam(required = false) String type) {
        // Implement filtering logic in JobService
        List<Job> jobs = jobService.getAllJobs(stack, type);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable UUID id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/apply/{id}")
    public ResponseEntity<Void> applyForJob(@PathVariable UUID id) {
        jobService.applyForJob(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/applied")
    public ResponseEntity<List<Job>> getAppliedJobs() {
        List<Job> appliedJobs = jobService.getAppliedJobs();
        return ResponseEntity.ok(appliedJobs);
    }
}