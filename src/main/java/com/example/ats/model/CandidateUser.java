package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="candidate_user")
public class CandidateUser implements Serializable {



    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    Date date;
    private String usertype;
    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private boolean accountisactive;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date registerdate;

/*    @OneToOne(cascade=CascadeType.PERSIST, mappedBy = "user")
    private Candidate candidate;*/



    public CandidateUser(){}



    public long getUserId() {
        return Id;
    }

    public CandidateUser setUserId(long userId) {
        this.Id = userId;
        return  this;
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

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }



/*    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
        this.setUserId(userId);
    }*/


}
