package com.example.ats.api;

import com.example.ats.model.Education;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.EducationRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/education")
public class EducationController
{
    @Autowired
    EducationRepository educationRepository;

    @Autowired
    CandidateUserRepository candidateUserRepository;

    @GetMapping
    public List<Education> getAllEducation(){
        return educationRepository.findAll();
    }

    @GetMapping("/{educationid}")
    public void getEducationById(@PathVariable(value = "id") Long educationId){
        educationRepository.findById(educationId)
                .orElseThrow(() -> new ResourceNotFoundException("Education", "id", educationId));

    }

//    @GetMapping("/educationlist")
//    public List<Education> getAllEducation(){
//        return educationRepository.getEducation();
//    }

    @PostMapping("/{candid}")
    public Education createEducation(@PathVariable(value = "candid") Long candid, @Valid @RequestBody Education education) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            education.setCandidateUser(user);
            return educationRepository.save(education);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }
}
