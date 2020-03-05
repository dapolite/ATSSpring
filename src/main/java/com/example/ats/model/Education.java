package com.example.ats.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Education {

    private String degree_name;
    private String institutie_name;
    private String subject;
    private Date edustart_date;
    private Date educomplete_date;
    private int edu_percentage;


}
