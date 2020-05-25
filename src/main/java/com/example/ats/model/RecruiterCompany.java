package com.example.ats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="recruiter_company_details")
public class RecruiterCompany implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyname;
    private String companydesc;
    private String companyaddress;
    private String companywebsite;
    private Date companyestdate;
    private Byte companypic;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn(name = "id")
    @JsonIgnore
    private RecruiterUser recruiterUser;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public Byte getCompanypic() {
        return companypic;
    }

    public void setCompanypic(Byte companypic) {
        this.companypic = companypic;
    }

    public RecruiterUser getRecruiterUser() {
        return recruiterUser;
    }

    public void setRecruiterUser(RecruiterUser recruiterUser) {
        this.recruiterUser = recruiterUser;
    }
}
