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
    private String joblocationaddress;
    private String joblocationcity;
    private String joblocationstate;
    private String joblocationcountry;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    private JobPost jobPost;

    public JobLocation(){}

    public JobLocation(Long joblocation_Id, String joblocationaddress, String joblocationcity, String joblocationstate, String joblocationcountry, JobPost jobPost) {
        this.joblocationId = joblocationId;
        this.joblocationaddress = joblocationaddress;
        this.joblocationcity = joblocationcity;
        this.joblocationstate = joblocationstate;
        this.joblocationcountry = joblocationcountry;
        this.jobPost = jobPost;
    }

    public Long getJoblocation_Id() {
        return joblocationId;
    }

    public void setJoblocation_Id(Long joblocationId) {
        this.joblocationId = joblocationId;
    }

    public String getJoblocation_address() {
        return joblocationaddress;
    }

    public void setJoblocation_address(String joblocationaddress) {
        this.joblocationaddress = joblocationaddress;
    }

    public String getJoblocation_city() {
        return joblocationcity;
    }

    public void setJoblocation_city(String joblocationcity) {
        this.joblocationcity = joblocationcity;
    }

    public String getJoblocation_state() {
        return joblocationstate;
    }

    public void setJoblocation_state(String joblocationstate) {
        this.joblocationstate = joblocationstate;
    }

    public String getJoblocation_country() {
        return joblocationcountry;
    }

    public void setJoblocation_country(String joblocationcountry) {
        this.joblocationcountry = joblocationcountry;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}
