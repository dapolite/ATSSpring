package com.example.ats.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ESPojo implements Serializable {
    private  String candidate_fname;
    private  String candidate_lname;
    private  String skillName;
    private  String qualificationDegree;
}
