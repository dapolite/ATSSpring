package com.example.ats.model;

import javax.persistence.*;
import java.sql.Timestamp;

//@Entity
public class JobPost {

        //@Id
        private Long jobpostid;

        private Timestamp jpbpost_createdate;
        private String jobpost_jobdesc;
        private boolean jobpost_isactive;
        private int jobpost_duration;



        //@ManyToOne(fetch = FetchType.LAZY, optional = false)
        //@JoinColumn
        private Recruiter recruiter;

        private JobType jobType;
        private JobLocation jobLocation;


}
