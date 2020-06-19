package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="job_post")
public class JobPost implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long jobpostid;

        private String jobposttitle;

        @CreationTimestamp
        private Date jobpostcreatedate;

        private String jobpostjobdesc;
        private String jobpostresponsibilities;
        private String jobpostbenefits;
        private String jobpostexperience;
        private String jobpostcategory;
        private String jobpostqualification;
        private boolean jobpostisactive;
        private boolean jobisapplied;
        private boolean jobisshortlisted;
        private String jobpostcompanyname;
        private String jobpostwebaddress;
        private String jobpostcompanyprofile;

        
        private Date jobpostdeadline;
        private String jobpostlocation;
        private String jobposttype;

        //private int jobpostduration;


        @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @PrimaryKeyJoinColumn(name = "id")
        @JsonIgnore
        private RecruiterUser recruiterUser;

        @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL)
        private Set<JobType> jobType = new HashSet<>();

        @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL)
        private Set<JobLocation> jobLocations = new HashSet<>();

        public String getJobposttitle() {
                return jobposttitle;
        }

        public void setJobposttitle(String jobposttitle) {
                this.jobposttitle = jobposttitle;
        }

        public String getJobpostresponsibilities() {
                return jobpostresponsibilities;
        }

        public void setJobpostresponsibilities(String jobpostresponsibilities) {
                this.jobpostresponsibilities = jobpostresponsibilities;
        }

        public String getJobpostbenefits() {
                return jobpostbenefits;
        }

        public void setJobpostbenefits(String jobpostbenefits) {
                this.jobpostbenefits = jobpostbenefits;
        }

        public String getJobpostexperience() {
                return jobpostexperience;
        }

        public void setJobpostexperience(String jobpostexperience) {
                this.jobpostexperience = jobpostexperience;
        }

        public String getJobpostqualification() {
                return jobpostqualification;
        }

        public void setJobpostqualification(String jobpostqualification) {
                this.jobpostqualification = jobpostqualification;
        }

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
                jobpostcreatedate=new Date();
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

//        public int getJobpostduration() {
//                return jobpostduration;
//        }
//
//        public void setJobpostduration(int jobpostduration) {
//                this.jobpostduration = jobpostduration;
//        }

        public RecruiterUser getRecruiterUser() {
                return recruiterUser;
        }

        public void setRecruiterUser(RecruiterUser recruiterUser) {
                this.recruiterUser = recruiterUser;
        }

        public Set<JobType> getJobType() {
                return jobType;
        }

        public void setJobType(Set<JobType> jobType) {
                this.jobType = jobType;
        }

        public Set<JobLocation> getJobLocations() {
                return jobLocations;
        }

        public void setJobLocations(Set<JobLocation> jobLocations) {
                this.jobLocations = jobLocations;
        }

        public boolean isJobisapplied() {
                return jobisapplied;
        }

        public void setJobisapplied(boolean jobisapplied) {
                this.jobisapplied = jobisapplied;
        }

        public boolean isJobisshortlisted() {
                return jobisshortlisted;
        }

        public void setJobisshortlisted(boolean jobisshortlisted) {
                this.jobisshortlisted = jobisshortlisted;
        }

        public String getJobpostcategory() {
                return jobpostcategory;
        }

        public void setJobpostcategory(String jobpostcategory) {
                this.jobpostcategory = jobpostcategory;
        }

        public String getJobpostcompanyname() {
                return jobpostcompanyname;
        }

        public void setJobpostcompanyname(String jobpostcompanyname) {
                this.jobpostcompanyname = jobpostcompanyname;
        }

        public String getJobpostwebaddress() {
                return jobpostwebaddress;
        }

        public void setJobpostwebaddress(String jobpostwebaddress) {
                this.jobpostwebaddress = jobpostwebaddress;
        }

        public String getJobpostcompanyprofile() {
                return jobpostcompanyprofile;
        }

        public void setJobpostcompanyprofile(String jobpostcompanyprofile) {
                this.jobpostcompanyprofile = jobpostcompanyprofile;
        }

        public Date getJobpostdeadline() {
                return jobpostdeadline;
        }

        public void setJobpostdeadline(Date jobpostdeadline) {
                this.jobpostdeadline = jobpostdeadline;
        }

        public String getJobpostlocation() {
                return jobpostlocation;
        }

        public void setJobpostlocation(String jobpostlocation) {
                this.jobpostlocation = jobpostlocation;
        }

        public String getJobposttype() {
                return jobposttype;
        }

        public void setJobposttype(String jobposttype) {
                this.jobposttype = jobposttype;
        }
}
