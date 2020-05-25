package com.example.ats.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="recruiter_user")
public class RecruiterUser implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private String firstname;
    private String lastname;
    private Date dob;
    private boolean accountisactive;

    @CreationTimestamp
    private Date registerdate;

    @OneToMany(mappedBy = "recruiterUser", cascade = CascadeType.PERSIST)
    private Set<JobPost> jobpost=new HashSet<>();

    @OneToMany(mappedBy = "recruiterUser", cascade = CascadeType.PERSIST)
    private Set<RecruiterCompany> recruiterCompanies = new HashSet<>();

/*    @OneToOne(mappedBy = "recruiterUser", cascade = CascadeType.ALL)
    private Set<Industry> industry=new HashSet<>();*/


    public RecruiterUser(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        registerdate=new Date();
        this.registerdate = registerdate;
    }

    public Set<JobPost> getJobpost() {
        return jobpost;
    }

    public void setJobpost(Set<JobPost> jobpost) {
        this.jobpost = jobpost;
    }

    public Set<RecruiterCompany> getRecruiterCompanies() {
        return recruiterCompanies;
    }

    public void setRecruiterCompanies(Set<RecruiterCompany> recruiterCompanies) {
        this.recruiterCompanies = recruiterCompanies;
    }

    /*    public Set<Industry> getIndustry() {
        return industry;
    }

    public void setIndustry(Set<Industry> industry) {
        this.industry = industry;
    }*/
}
