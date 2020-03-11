package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="candidate_user")
//@MappedSuperclass
public class CandidateUser implements Serializable {



    @Id
    @NotNull
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    Date date;
    private String usertype;
    private String userName;
    private String password;
    private String email;
    private String phoneno;
    private boolean accountisactive;
    private String candidate_fname;
    private String candidate_lname;
    private String candidate_address;
    private String candidate_about;
    private String candidate_profpic;
    private String candidateloc_city;
    private String candidateloc_state;
    private String candidateloc_country;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date registerdate;

/*    @OneToOne(cascade=CascadeType.PERSIST, mappedBy = "user")
    private Candidate candidate;*/


    public CandidateUser(long id, Date date, String usertype, String userName, String password, String email, String phoneno, boolean accountisactive, String candidate_fname, String candidate_lname, String candidate_address, String candidate_about, String candidate_profpic, String candidateloc_city, String candidateloc_state, String candidateloc_country, Date registerdate) {
        Id = id;
        this.date = date;
        this.usertype = usertype;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneno = phoneno;
        this.accountisactive = accountisactive;
        this.candidate_fname = candidate_fname;
        this.candidate_lname = candidate_lname;
        this.candidate_address = candidate_address;
        this.candidate_about = candidate_about;
        this.candidate_profpic = candidate_profpic;
        this.candidateloc_city = candidateloc_city;
        this.candidateloc_state = candidateloc_state;
        this.candidateloc_country = candidateloc_country;
        this.registerdate = registerdate;
    }

    public CandidateUser(){}

    /*public CandidateUser(long id, String usertype, String userName, String password, String email, String phoneno, boolean accountisactive, Date registerdate) {
        Id = id;
        this.usertype = usertype;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneno = phoneno;
        this.accountisactive = accountisactive;
        this.registerdate = registerdate;
    }*/

    public long getUserId() {
        return Id;
    }

    public void setUserId(long userId) {
        this.Id = userId;
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

    /*public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCandidate_fname() {
        return candidate_fname;
    }

    public void setCandidate_fname(String candidate_fname) {
        this.candidate_fname = candidate_fname;
    }

    public String getCandidate_lname() {
        return candidate_lname;
    }

    public void setCandidate_lname(String candidate_lname) {
        this.candidate_lname = candidate_lname;
    }

    public String getCandidate_address() {
        return candidate_address;
    }

    public void setCandidate_address(String candidate_address) {
        this.candidate_address = candidate_address;
    }

    public String getCandidate_about() {
        return candidate_about;
    }

    public void setCandidate_about(String candidate_about) {
        this.candidate_about = candidate_about;
    }

    public String getCandidate_profpic() {
        return candidate_profpic;
    }

    public void setCandidate_profpic(String candidate_profpic) {
        this.candidate_profpic = candidate_profpic;
    }

    public String getCandidateloc_city() {
        return candidateloc_city;
    }

    public void setCandidateloc_city(String candidateloc_city) {
        this.candidateloc_city = candidateloc_city;
    }

    public String getCandidateloc_state() {
        return candidateloc_state;
    }

    public void setCandidateloc_state(String candidateloc_state) {
        this.candidateloc_state = candidateloc_state;
    }

    public String getCandidateloc_country() {
        return candidateloc_country;
    }

    public void setCandidateloc_country(String candidateloc_country) {
        this.candidateloc_country = candidateloc_country;
    }

    /*    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
        this.setUserId(userId);
    }*/


}
