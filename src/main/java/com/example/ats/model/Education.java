package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Education implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    private String nameOfInstitute;
    private String locationOfInstitute;
    private String qualificationDegree;
    private Long cgpa;
    private Long yearOfPassing;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    @MapsId
    private CandidateUser candidateUser;

    public Long getEducationId() {
        return educationId;
    }

    public void setEducationId(Long educationId) {
        this.educationId = educationId;
    }

    public String getNameOfInstitute() {
        return nameOfInstitute;
    }

    public void setNameOfInstitute(String nameOfInstitute) {
        this.nameOfInstitute = nameOfInstitute;
    }

    public String getLocationOfInstitute() {
        return locationOfInstitute;
    }

    public void setLocationOfInstitute(String locationOfInstitute) {
        this.locationOfInstitute = locationOfInstitute;
    }

    public String getQualificationDegree() {
        return qualificationDegree;
    }

    public void setQualificationDegree(String qualificationDegree) {
        this.qualificationDegree = qualificationDegree;
    }

    public Long getCgpa() {
        return cgpa;
    }

    public void setCgpa(Long cgpa) {
        this.cgpa = cgpa;
    }

    public Long getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(Long yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public CandidateUser getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(CandidateUser candidateUser) {
        this.candidateUser = candidateUser;
    }
}
