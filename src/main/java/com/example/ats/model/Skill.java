package com.example.ats.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {

    @Id
    private Long skill_id;
    private String skill_name;
}
