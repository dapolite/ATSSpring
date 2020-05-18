package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="candidate_user")
public class CandidateUser implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String usertype = "CANDIDATE";
    private String userName;
    private String password;
    private String email;
    private Date dob;
    private String phoneno;
    private boolean accountisactive;
    private String candidate_fname;
    private String candidate_lname;
    private String candidate_address;
    private String candidate_about;
    private Byte candidate_profpic;
    private String candidateloc_city;
    private String candidateloc_state;
    private String candidateloc_country;

    @CreationTimestamp
    private Date registerdate;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL    )
    private Set<Skill> skills;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL)
    private Set<CandidateResume> candidateResumes;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL)
    private Set<Education> educations;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL)
    private Set<Experience> experiences;

    public CandidateUser(){}

    public long getUserId() {
        return Id;
    }

    public void setUserId(long userId) {
        this.Id = userId;
    }

    public String getUsertype() {
        return usertype;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public boolean isAccountisactive() {
        return accountisactive;
    }

    public void setAccountisactive(boolean accountisactive) {
        this.accountisactive = accountisactive;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
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

    public Byte getCandidate_profpic() {
        return candidate_profpic;
    }

    public void setCandidate_profpic(Byte candidate_profpic) {
        this.candidate_profpic = candidate_profpic;
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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<CandidateResume> getCandidateResumes() {
        return candidateResumes;
    }

    public void setCandidateResumes(Set<CandidateResume> candidateResumes) {
        this.candidateResumes = candidateResumes;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }
}