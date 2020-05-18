package com.example.ats.repository;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.ats.model.CandidateUser;

@Repository
//public interface CandidateUserRepository extends ElasticsearchRepository<CandidateUser, Long> {
//    Optional<CandidateUser> findByUserName(String username);
//}
public interface CandidateUserRepository extends JpaRepository<CandidateUser, Long> {
    Optional<CandidateUser> findByUserName(String username);
}
