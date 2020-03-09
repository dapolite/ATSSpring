package com.example.ats.model;

import javax.persistence.*;
import java.util.Date;

//@Entity
public class Education {

    @Id
    private Long education_id;
    private String degree_name;
    private String institutie_name;
    private String subject;
    private Date edustart_date;
    private Date educomplete_date;
    private int edu_percentage;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn
    private Candidate candidate;


}
