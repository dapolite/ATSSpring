package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="recruiter_user")
public class RecruiterUser {

    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String usertype;
    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private boolean accountisactive;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp registerdate;

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Recruiter recruiter;


    public RecruiterUser(){}

    public long getUserId() {
        return Id;
    }

    public void setUserId(long userId) {
        this.Id = userId;
    }

    public Timestamp getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Timestamp registerdate) {
        this.registerdate = registerdate;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
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

    public boolean isAccountisactive() {
        return accountisactive;
    }

    public void setAccountisactive(boolean accountisactive) {
        this.accountisactive = accountisactive;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}
