package com.example.ats.repository;

import com.example.ats.model.CandidateResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateResumeRepository extends JpaRepository<CandidateResume,Long> {
}
