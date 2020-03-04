
package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Recruiter {

    @Id
    private Long recruiterId;
    private Long industryid;
    private String companyname;
    private String companydesc;
    private String companyaddress;
    private String companywebsite;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date companyestdate;
    private String companylogo;

    @OneToOne
    @JoinColumn
    @MapsId
    private Users users;

    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Long recruiterId) {
        this.recruiterId = recruiterId;
    }

    public Long getIndustryid() {
        return industryid;
    }

    public void setIndustryid(Long industryid) {
        this.industryid = industryid;
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

    public Date getCompanyestdate() {
        return companyestdate;
    }

    public void setCompanyestdate(Date companyestdate) {
        this.companyestdate = companyestdate;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

