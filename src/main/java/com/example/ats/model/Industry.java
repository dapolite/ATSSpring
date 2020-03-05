package com.example.ats.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Industry {

    @Id
    private Long industry_id;
    private String industry_name;
}
