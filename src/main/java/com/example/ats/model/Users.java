package com.example.ats.model;

import javax.persistence.*;


@Entity
@Table(name="ATSUser")
public class Users {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private Long userTypeId;
    private String usertype;
    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private boolean accountisactive;
    private String registerdate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Recruiter recruiter;



    public Users(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
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

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
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
