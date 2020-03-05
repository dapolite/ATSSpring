package com.example.ats.model;

import javax.persistence.*;

@Entity
@Table(name="candidate_details")
public class Candidate {

    @Id
    private Long candidateId;

    private String candidate_fname;
    private String candidate_lname;
    private String candidate_address;
    private String candidate_about;

    @OneToOne
    @JoinColumn
    @MapsId
    private CandidateUser user;

    public Candidate(){}

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidate_fname() {
        return candidate_fname;
    }

    public void setCandidate_fname(String candidate_fname) {
        this.candidate_fname = candidate_fname;
    }

    public String getCandidate_lname() {
        return candidate_lname;
    }

    public void setCandidate_lname(String candidate_lname) {
        this.candidate_lname = candidate_lname;
    }

    public String getCandidate_address() {
        return candidate_address;
    }

    public void setCandidate_address(String candidate_address) {
        this.candidate_address = candidate_address;
    }

    public String getCandidate_about() {
        return candidate_about;
    }

    public void setCandidate_about(String candidate_about) {
        this.candidate_about = candidate_about;
    }

    public CandidateUser getUser() {
        return user;
    }

    public void setUser(CandidateUser user) {
        this.user = user;
    }
}
