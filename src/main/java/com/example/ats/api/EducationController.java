package com.example.ats.api;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.Education;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.EducationRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
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

    @PostMapping("/{candid}/post")
    public Education createEducation(@PathVariable(value = "candid") Long candid, @Valid @RequestBody Education education) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            education.setCandidateUser(user);
            return educationRepository.save(education);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }

    @PutMapping("/{id}/update")
    public Education updateEducation(
            @PathVariable(value = "id") Long id, @Valid @RequestBody Education educationdetails)
            throws ResourceNotFoundException {
        Education candidate =
                educationRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + id));
        candidate.setLocationOfInstitute(educationdetails.getLocationOfInstitute());
        candidate.setNameOfInstitute(educationdetails.getNameOfInstitute());
        candidate.setCgpa(educationdetails.getCgpa());
        candidate.setQualificationDegree(educationdetails.getQualificationDegree());
        candidate.setYearOfPassing(educationdetails.getYearOfPassing());
        Education updated=educationRepository.save(candidate);
        return updated;
    }


    @DeleteMapping("/{id}/delete")
    public Map<String, Boolean> deleteEducation(@PathVariable(value = "id") Long educationId) throws Exception {
        Education education =
                educationRepository
                        .findById(educationId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + educationId));
        educationRepository.delete(education);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
