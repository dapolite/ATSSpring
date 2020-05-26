package com.example.ats.repository;

import com.example.ats.model.CandidateUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateUserESRepository extends ElasticsearchRepository<CandidateUser,Long> {
    CandidateUser findByUsername(String username);

}
