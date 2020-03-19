package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class JobLocation {

    @Id
    private Long joblocation_Id;
    private String joblocation_address;
    private String joblocation_city;
    private String joblocation_state;
    private String joblocation_country;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    private JobPost jobPost;

    public JobLocation(Long joblocation_Id, String joblocation_address, String joblocation_city, String joblocation_state, String joblocation_country, JobPost jobPost) {
        this.joblocation_Id = joblocation_Id;
        this.joblocation_address = joblocation_address;
        this.joblocation_city = joblocation_city;
        this.joblocation_state = joblocation_state;
        this.joblocation_country = joblocation_country;
        this.jobPost = jobPost;
    }

    public Long getJoblocation_Id() {
        return joblocation_Id;
    }

    public void setJoblocation_Id(Long joblocation_Id) {
        this.joblocation_Id = joblocation_Id;
    }

    public String getJoblocation_address() {
        return joblocation_address;
    }

    public void setJoblocation_address(String joblocation_address) {
        this.joblocation_address = joblocation_address;
    }

    public String getJoblocation_city() {
        return joblocation_city;
    }

    public void setJoblocation_city(String joblocation_city) {
        this.joblocation_city = joblocation_city;
    }

    public String getJoblocation_state() {
        return joblocation_state;
    }

    public void setJoblocation_state(String joblocation_state) {
        this.joblocation_state = joblocation_state;
    }

    public String getJoblocation_country() {
        return joblocation_country;
    }

    public void setJoblocation_country(String joblocation_country) {
        this.joblocation_country = joblocation_country;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}
