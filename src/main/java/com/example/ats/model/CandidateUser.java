package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="candidate_user")
//@Document(indexName = "userdetails", type = "candidate")
//@EntityListeners({IndexingCandidateListener.class})
//@MappedSuperclass


public class CandidateUser implements Serializable {


    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@org.springframework.data.annotation.Id
    @Id
    private long Id;

    Date date;
    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private boolean accountisactive;
    private String candidate_fname;
    private String candidate_lname;
    private String candidate_address;
    private String candidate_about;
    private String candidate_profpic;
    private String candidateloc_city;
    private String candidateloc_state;
    private String candidateloc_country;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date registerdate;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Skill> skills=new HashSet<>();

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CandidateResume> candidateResumes;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Education> educations;

    @OneToMany(mappedBy = "candidateUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Experience> experiences;

    public CandidateUser(long id, Date date, String userName, String password, String email, String phoneno, boolean accountisactive, String candidate_fname, String candidate_lname, String candidate_address, String candidate_about, String candidate_profpic, String candidateloc_city, String candidateloc_state, String candidateloc_country, Date registerdate) {
        Id = id;
        this.date = date;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneno = phoneno;
        this.accountisactive = accountisactive;
        this.candidate_fname = candidate_fname;
        this.candidate_lname = candidate_lname;
        this.candidate_address = candidate_address;
        this.candidate_about = candidate_about;
        this.candidate_profpic = candidate_profpic;
        this.candidateloc_city = candidateloc_city;
        this.candidateloc_state = candidateloc_state;
        this.candidateloc_country = candidateloc_country;
        this.registerdate = registerdate;
    }

    public CandidateUser(){}

    public long getUserId() {
        return Id;
    }

    public void setUserId(long userId) {
        this.Id = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
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

    public String getCandidate_profpic() {
        return candidate_profpic;
    }

    public void setCandidate_profpic(String candidate_profpic) {
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