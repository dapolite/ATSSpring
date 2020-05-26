package com.example.ats.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.ats.model.ESPojo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.ats.model.CandidateUser;

@Repository
public interface CandidateUserRepository extends JpaRepository<CandidateUser, Long> {
    Optional<CandidateUser> findByUserName(String username);

    @Query("SELECT user from CandidateUser user LEFT JOIN user.educations edu LEFT JOIN user.experiences exp LEFT JOIN user.skills sk")
    List<CandidateUser> getData();

}
