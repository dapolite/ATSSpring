package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="job_location")
public class JobLocation implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long joblocationId;

    private String joblocationaddress;
    private String joblocationcity;
    private String joblocationstate;
    private String joblocationcountry;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "jobPostId",nullable = false)
    //@JsonIgnore
    @JsonBackReference
    private JobPost jobPost;

    public Long getJoblocationId() {
        return joblocationId;
    }

    public void setJoblocationId(Long joblocationId) {
        this.joblocationId = joblocationId;
    }

    public String getJoblocationaddress() {
        return joblocationaddress;
    }

    public void setJoblocationaddress(String joblocationaddress) {
        this.joblocationaddress = joblocationaddress;
    }

    public String getJoblocationcity() {
        return joblocationcity;
    }

    public void setJoblocationcity(String joblocationcity) {
        this.joblocationcity = joblocationcity;
    }

    public String getJoblocationstate() {
        return joblocationstate;
    }

    public void setJoblocationstate(String joblocationstate) {
        this.joblocationstate = joblocationstate;
    }

    public String getJoblocationcountry() {
        return joblocationcountry;
    }

    public void setJoblocationcountry(String joblocationcountry) {
        this.joblocationcountry = joblocationcountry;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}