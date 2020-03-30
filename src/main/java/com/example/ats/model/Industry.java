package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Industry {

    @Id
    private Long industry_id;
    private String industry_name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "recid")
    @JsonIgnore
    RecruiterUser recruiterUser;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "jpid")
    @JsonIgnore
    JobPost jobPost;

    public Industry(){}

    public Industry(Long industry_id, String industry_name, RecruiterUser recruiterUser, JobPost jobPost) {
        this.industry_id = industry_id;
        this.industry_name = industry_name;
        this.recruiterUser = recruiterUser;
        this.jobPost = jobPost;
    }

    public Long getIndustry_id() {
        return industry_id;
    }

    public void setIndustry_id(Long industry_id) {
        this.industry_id = industry_id;
    }

    public String getIndustry_name() {
        return industry_name;
    }

    public void setIndustry_name(String industry_name) {
        this.industry_name = industry_name;
    }

    public RecruiterUser getRecruiterUser() {
        return recruiterUser;
    }

    public void setRecruiterUser(RecruiterUser recruiterUser) {
        this.recruiterUser = recruiterUser;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}
