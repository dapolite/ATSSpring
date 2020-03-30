package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Industry {

    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long industryid;
    private String industryname;

/*    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "recid")
    @JsonIgnore
    private RecruiterUser recruiterUser;*/

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "jpid")
    @JsonIgnore
    private JobPost jobPost;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "canid")
    @JsonIgnore
    private CandidateUser candidateUser;

    public Industry(){}


    public Long getIndustry_id() {
        return industryid;
    }

    public void setIndustry_id(Long industry_id) {
        this.industryid = industryid;
    }

    public String getIndustry_name() {
        return industryname;
    }

    public void setIndustry_name(String industry_name) {
        this.industryname = industryname;
    }

/*    public RecruiterUser getRecruiterUser() {
        return recruiterUser;
    }

    public void setRecruiterUser(RecruiterUser recruiterUser) {
        this.recruiterUser = recruiterUser;
    }*/

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    public CandidateUser getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(CandidateUser candidateUser) {
        this.candidateUser = candidateUser;
    }
}
