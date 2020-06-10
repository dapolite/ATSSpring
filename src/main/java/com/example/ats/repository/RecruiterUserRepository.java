package com.example.ats.repository;

import java.util.List;
import java.util.Optional;

import com.example.ats.model.CandidateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ats.model.RecruiterUser;

@Repository
public interface RecruiterUserRepository extends JpaRepository<RecruiterUser,Long> {
    Optional<RecruiterUser> findByUserName(String username);

    @Query("SELECT user from RecruiterUser user LEFT JOIN user.jobpost jpost")
    List<RecruiterUser> getRecData();

    @Query("SELECT u from RecruiterUser u where u.userName = :username")
    RecruiterUser findUsersByRecruiterUsername(@Param("username")String username);

    @Query("SELECT u.id from RecruiterUser u where u.userName = :username")
    Long findUserIdByRecruiterUsername(@Param("username")String username);
}
