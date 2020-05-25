package com.example.ats.repository;

import com.example.ats.model.RecruiterCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterCompanyRepository extends JpaRepository<RecruiterCompany, Long> {
}