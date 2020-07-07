package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="job_type")
public class JobType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobtypeid;

    @NotNull
    private String jobtypename;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "jobPostId", nullable = false)
    //@JsonIgnore
    @JsonBackReference
    private JobPost jobPost;

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