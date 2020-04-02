package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="recruiter_user")
public class RecruiterUser implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;

    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private String firstname;
    private String lastname;
    private boolean accountisactive;

    private String companyname;
    private String companydesc;
    private String companyaddress;
    private String companywebsite;

    private Byte companypic;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registerdate;

    @OneToMany(mappedBy = "recruiterUser", cascade = CascadeType.PERSIST)
    private Set<JobPost> jobpost=new HashSet<>();

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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanydesc() {
        return companydesc;
    }

    public void setCompanydesc(String companydesc) {
        this.companydesc = companydesc;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getCompanywebsite() {
        return companywebsite;
    }

    public void setCompanywebsite(String companywebsite) {
        this.companywebsite = companywebsite;
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

    public void setJobpos(Set<JobPost> jobpost) {
        this.jobpost = jobpost;
    }

/*    public Set<Industry> getIndustry() {
        return industry;
    }

    public void setIndustry(Set<Industry> industry) {
        this.industry = industry;
    }*/

    public Byte getCompanypic() {
        return companypic;
    }

    public void setCompanypic(Byte companypic) {
        this.companypic = companypic;
    }
}
