package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class JobType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobtypeid;

    private String jobtypename;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonIgnore
    private JobPost jobPost;

    public JobType(Long jobtypeid, String jobtypename, JobPost jobPost) {
        this.jobtypeid = jobtypeid;
        this.jobtypename = jobtypename;
        this.jobPost = jobPost;
    }

    public Long getJobtypeid() {
        return jobtypeid;
    }

    public void setJobtypeid(Long jobtypeid) {
        this.jobtypeid = jobtypeid;
    }

    public String getJobtypename() {
        return jobtypename;
    }

    public void setJobtypename(String jobtypename) {
        this.jobtypename = jobtypename;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}
