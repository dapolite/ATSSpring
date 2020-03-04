package com.example.ats.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ats.model.CandidateUser;

@Repository
public interface CandidateUserRepository extends JpaRepository<CandidateUser, Long> {
    Optional<CandidateUser> findByUserName(String username);
}
