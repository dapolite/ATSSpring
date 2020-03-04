package com.example.ats.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ats.model.RecruiterUser;

@Repository
public interface RecruiterUserRepository extends JpaRepository<RecruiterUser,Long> {
    Optional<RecruiterUser> findByUserName(String username);
}
