package com.example.ats.repository;

import com.example.ats.model.CandidateUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CandidateUserESRepository extends ElasticsearchRepository<CandidateUser,Long> {
    CandidateUser findByUsername(String username);
}
