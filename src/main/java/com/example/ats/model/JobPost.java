package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class JobPost implements Serializable {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long jobpostid;

        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date jobpostcreatedate;
        private String jobpostjobdesc;
        private boolean jobpostisactive;
        private int jobpostduration;


        @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
        @PrimaryKeyJoinColumn(name = "id")
        @JsonIgnore
        private RecruiterUser recruiterUser;

        @OneToOne(mappedBy = "jobPost", cascade = CascadeType.PERSIST)
        @JoinColumn(name="jobtypeid")
        private JobType jobType;

        @OneToOne(mappedBy = "jobPost", cascade = CascadeType.PERSIST)
        private JobLocation jobLocation;

        public Long getJobpostid() {
                return jobpostid;
        }

        public void setJobpostid(Long jobpostid) {
                this.jobpostid = jobpostid;
        }

        public Date getJobpostcreatedate() {
                return jobpostcreatedate;
        }

        public void setJobpostcreatedate(Date jobpostcreatedate) {
                this.jobpostcreatedate = jobpostcreatedate;
        }

        public String getJobpostjobdesc() {
                return jobpostjobdesc;
        }

        public void setJobpostjobdesc(String jobpostjobdesc) {
                this.jobpostjobdesc = jobpostjobdesc;
        }

        public boolean isJobpostisactive() {
                return jobpostisactive;
        }

        public void setJobpostisactive(boolean jobpostisactive) {
                this.jobpostisactive = jobpostisactive;
        }

        public int getJobpostduration() {
                return jobpostduration;
        }

        public void setJobpostduration(int jobpostduration) {
                this.jobpostduration = jobpostduration;
        }

        public RecruiterUser getRecruiterUser() {
                return recruiterUser;
        }

        public void setRecruiterUser(RecruiterUser recruiterUser) {
                this.recruiterUser = recruiterUser;
        }

        public JobType getJobType() {
                return jobType;
        }

        public void setJobType(JobType jobType) {
                this.jobType = jobType;
        }

        public JobLocation getJobLocation() {
                return jobLocation;
        }

        public void setJobLocation(JobLocation jobLocation) {
                this.jobLocation = jobLocation;
        }
}
