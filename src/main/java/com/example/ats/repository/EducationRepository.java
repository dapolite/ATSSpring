package com.example.ats.repository;

import com.example.ats.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {

//    @Query("SELECT edu FROM Education edu WHERE edu.yearOfPassing = 2020")
//    List<Education> getEducation();
}
