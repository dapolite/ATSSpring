package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="job_location")
public class JobLocation implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long joblocationId;

    private String jobaddress;
    private String jobcity;
    private String jobstate;
    private String jobcountry;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    private JobPost jobPost;

    public Long getJoblocationId() {
        return joblocationId;
    }

    public void setJoblocationId(Long joblocationId) {
        this.joblocationId = joblocationId;
    }

    public String getJobaddress() {
        return jobaddress;
    }

    public void setJobaddress(String jobaddress) {
        this.jobaddress = jobaddress;
    }

    public String getJobcity() {
        return jobcity;
    }

    public void setJobcity(String jobcity) {
        this.jobcity = jobcity;
    }

    public String getJobstate() {
        return jobstate;
    }

    public void setJobstate(String jobstate) {
        this.jobstate = jobstate;
    }

    public String getJobcountry() {
        return jobcountry;
    }

    public void setJobcountry(String jobcountry) {
        this.jobcountry = jobcountry;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}
