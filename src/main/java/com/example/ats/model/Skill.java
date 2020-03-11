package com.example.ats.model;

import javax.persistence.*;

//@Entity
public class Skill {

    //@Id
    private Long skill_id;
    private String skill_name;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn
    private CandidateUser candidateUser;
}
