package com.example.ats.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class JobType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobtype_id;
    private String jobtype_name;
}
