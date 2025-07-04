package com.devconnect.repository;

import com.devconnect.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
}