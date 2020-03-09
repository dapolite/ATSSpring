package com.example.ats.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="candidate_details")
public class Candidate implements Serializable {

    @Id
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long candidateId;

    private String candidate_fname;
    private String candidate_lname;
    private String candidate_address;
    private String candidate_about;
    private String candidate_profpic;
    private String candidateloc_city;
    private String candidateloc_state;
    private String candidateloc_country;

    @MapsId
    @OneToOne
    @JoinColumn(name="candidate_id", referencedColumnName="user_id")
    private CandidateUser user;

    public CandidateUser getUser() {
        return user;
    }

    public void setUser(CandidateUser user) {
        this.user = user;
        this.candidateId=user.getUserId();
    }
//private Industry industry;

    //@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //private Set<Skill> skills;
    //@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //private Set<Experience> experiences;
    //@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //private Set<Education> educations;


    public Candidate(){}

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
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

    public String getCandidateloc_city() {
        return candidateloc_city;
    }

    public void setCandidateloc_city(String candidateloc_city) {
        this.candidateloc_city = candidateloc_city;
    }

    public String getCandidateloc_state() {
        return candidateloc_state;
    }

    public void setCandidateloc_state(String candidateloc_state) {
        this.candidateloc_state = candidateloc_state;
    }

    public String getCandidateloc_country() {
        return candidateloc_country;
    }

    public void setCandidateloc_country(String candidateloc_country) {
        this.candidateloc_country = candidateloc_country;
    }

    public String getCandidate_profpic() {
        return candidate_profpic;
    }

    public void setCandidate_profpic(String candidate_profpic) {
        this.candidate_profpic = candidate_profpic;
    }
}
