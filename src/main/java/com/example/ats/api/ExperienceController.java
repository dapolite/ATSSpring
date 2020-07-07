package com.example.ats.api;

import com.example.ats.model.Education;
import com.example.ats.model.Experience;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.ExperienceRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/experience")
public class ExperienceController
{
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    CandidateUserRepository candidateUserRepository;

    @GetMapping
    public List<Experience> getAllExperience(){
        return experienceRepository.findAll();
    }

    @GetMapping("/{experienceid}")
    public void getExperienceById(@PathVariable(value = "id") Long experienceId){
        experienceRepository.findById(experienceId)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "id", experienceId));
    }

    @PostMapping("/{candid}/post")
    public Experience createExperience(@PathVariable(value = "candid") Long candid, @Valid @RequestBody Experience experience) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            experience.setCandidateUser(user);
            return experienceRepository.save(experience);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }

    @PutMapping("/{id}/update")
    public Experience updateExperience(
            @PathVariable(value = "id") Long id, @Valid @RequestBody Experience experiencedetails)
            throws ResourceNotFoundException {
        Experience candidate =
                experienceRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Education not found on :: " + id));
        candidate.setExperienceCompanyname(experiencedetails.getExperienceCompanyname());
        candidate.setExperienceJobdesc(experiencedetails.getExperienceJobdesc());
        candidate.setJobTitle(experiencedetails.getJobTitle());
        candidate.setExperienceJoblocationcity(experiencedetails.getExperienceJoblocationcity());
        candidate.setStartDate(experiencedetails.getStartDate());
        candidate.setEndDate(experiencedetails.getEndDate());
        candidate.setExperienceJoblocationcountry(experiencedetails.getExperienceJoblocationcountry());
        candidate.setExperienceJoblocationstate(experiencedetails.getExperienceJoblocationstate());
        candidate.setExperienceyears(experiencedetails.getExperienceyears());
        Experience updated=experienceRepository.save(candidate);
        return updated;
    }


    @DeleteMapping("/{id}/delete")
    public Map<String, Boolean> deleteExperience(@PathVariable(value = "id") Long experienceId) throws Exception {
        Experience experience =
                experienceRepository
                        .findById(experienceId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + experienceId));
        experienceRepository.delete(experience);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
