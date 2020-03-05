package com.example.ats.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class JobPost {

        @Id
        private Long jobpostid;

        private Timestamp jpbpost_createdate;
        private String jobpost_jobdesc;
        private boolean jobpost_isactive;
        private int jobpost_duration;

        private Recruiter recruiter;



}
