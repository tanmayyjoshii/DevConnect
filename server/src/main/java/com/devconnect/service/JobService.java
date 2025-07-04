package com.devconnect.service;

import com.devconnect.model.Job;
import com.devconnect.model.User;
import com.devconnect.repository.JobRepository;
import com.devconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository; // Assuming you need this to find users for application logic

    @Autowired
    public JobService(JobRepository jobRepository, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public Job createJob(Job job) {
        // Add validation or business logic before saving
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs(String stack, String type) {
        List<Job> jobs = jobRepository.findAll();

        // Apply filtering
        if (stack != null && !stack.isEmpty()) {
            jobs = jobs.stream()
                    .filter(job -> job.getStack() != null && job.getStack().contains(stack))
                    .collect(Collectors.toList());
        }

        if (type != null && !type.isEmpty()) {
            jobs = jobs.stream()
                    .filter(job -> job.getType() != null && job.getType().equalsIgnoreCase(type))
                    .collect(Collectors.toList());
        }

        return jobs;
    }

    public Optional<Job> getJobById(UUID id) {
        return jobRepository.findById(id);
    }

    public Job applyForJob(UUID jobId, UUID userId) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (jobOptional.isPresent() && userOptional.isPresent()) {
            Job job = jobOptional.get();
            User user = userOptional.get();

            // Ensure applicants list is not null
            if (job.getApplicants() == null) {
                job.setApplicants(new java.util.ArrayList<>());
            }

            // Add applicant if not already present
            if (!job.getApplicants().contains(userId.toString())) {
                job.getApplicants().add(userId.toString());
                return jobRepository.save(job);
            } else {
                // User has already applied
                return job; // Or throw an exception indicating they already applied
            }
        }
        // Handle cases where job or user not found
        return null; // Or throw appropriate exceptions
    }

    public List<Job> getAppliedJobsForUser(UUID userId) {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs.stream()
                .filter(job -> job.getApplicants() != null && job.getApplicants().contains(userId.toString()))
                .collect(Collectors.toList());
    }
}