package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Experience implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceId;

    private Date startDate;
    private Date endDate;
    private String jobTitle;
    private String experienceCompanyname;
    private int experienceyears;
    private String experienceJoblocationcity;
    private String experienceJoblocationstate;
    private String experienceJoblocationcountry;
    private String experienceJobdesc;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    private CandidateUser candidateUser;

    public Long getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getExperienceCompanyname() {
        return experienceCompanyname;
    }

    public void setExperienceCompanyname(String experienceCompanyname) {
        this.experienceCompanyname = experienceCompanyname;
    }

    public String getExperienceJoblocationcity() {
        return experienceJoblocationcity;
    }

    public void setExperienceJoblocationcity(String experienceJoblocationcity) {
        this.experienceJoblocationcity = experienceJoblocationcity;
    }

    public String getExperienceJoblocationstate() {
        return experienceJoblocationstate;
    }

    public void setExperienceJoblocationstate(String experienceJoblocationstate) {
        this.experienceJoblocationstate = experienceJoblocationstate;
    }

    public String getExperienceJoblocationcountry() {
        return experienceJoblocationcountry;
    }

    public int getExperienceyears() {
        return experienceyears;
    }

    public void setExperienceyears(int experienceyears) {
        this.experienceyears = experienceyears;
    }

    public void setExperienceJoblocationcountry(String experienceJoblocationcountry) {
        this.experienceJoblocationcountry = experienceJoblocationcountry;
    }

    public String getExperienceJobdesc() {
        return experienceJobdesc;
    }

    public void setExperienceJobdesc(String experienceJobdesc) {
        this.experienceJobdesc = experienceJobdesc;
    }

    public CandidateUser getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(CandidateUser candidateUser) {
        this.candidateUser = candidateUser;
    }
}
