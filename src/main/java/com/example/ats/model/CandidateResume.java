package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="candidate_resume")
public class CandidateResume implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    private Date candidate_dob;
    private String candidate_fullname;
    private String candidate_info;
    private String candidate_about;
    private String candidate_fathername;
    private String candidate_mothername;
    private String candidate_nationality;
    private String candidate_address;
    private String candidate_sex;
    private String candidate_resume;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    @MapsId
    private CandidateUser candidateUser;

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public Date getCandidate_dob() {
        return candidate_dob;
    }

    public void setCandidate_dob(Date candidate_dob) {
        this.candidate_dob = candidate_dob;
    }

    public String getCandidate_fullname() {
        return candidate_fullname;
    }

    public void setCandidate_fullname(String candidate_fullname) {
        this.candidate_fullname = candidate_fullname;
    }

    public String getCandidate_info() {
        return candidate_info;
    }

    public void setCandidate_info(String candidate_info) {
        this.candidate_info = candidate_info;
    }

    public String getCandidate_about() {
        return candidate_about;
    }

    public void setCandidate_about(String candidate_about) {
        this.candidate_about = candidate_about;
    }

    public String getCandidate_fathername() {
        return candidate_fathername;
    }

    public void setCandidate_fathername(String candidate_fathername) {
        this.candidate_fathername = candidate_fathername;
    }

    public String getCandidate_mothername() {
        return candidate_mothername;
    }

    public void setCandidate_mothername(String candidate_mothername) {
        this.candidate_mothername = candidate_mothername;
    }

    public String getCandidate_nationality() {
        return candidate_nationality;
    }

    public void setCandidate_nationality(String candidate_nationality) {
        this.candidate_nationality = candidate_nationality;
    }

    public String getCandidate_address() {
        return candidate_address;
    }

    public void setCandidate_address(String candidate_address) {
        this.candidate_address = candidate_address;
    }

    public String getCandidate_sex() {
        return candidate_sex;
    }

    public void setCandidate_sex(String candidate_sex) {
        this.candidate_sex = candidate_sex;
    }

    public String getCandidate_resume() {
        return candidate_resume;
    }

    public void setCandidate_resume(String candidate_resume) {
        this.candidate_resume = candidate_resume;
    }

    public CandidateUser getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(CandidateUser candidateUser) {
        this.candidateUser = candidateUser;
    }
}
