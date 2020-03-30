package com.example.ats.repository;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {

}
