
package com.example.ats.repository;

import com.example.ats.model.JobPost;
import com.example.ats.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType,Long> {
}

