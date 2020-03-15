package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Skill {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long skillId;
    private String skillName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    private CandidateUser candidateUser;

    public Skill(){}

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Skill(String skillName, CandidateUser candidateUser) {
        this.skillName = skillName;
        this.candidateUser = candidateUser;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public CandidateUser getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(CandidateUser candidateUser) {
        this.candidateUser = candidateUser;
    }
}
