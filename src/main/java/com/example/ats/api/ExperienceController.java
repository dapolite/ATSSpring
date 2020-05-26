package com.example.ats.api;

import com.example.ats.model.Education;
import com.example.ats.model.Experience;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.ExperienceRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")

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

    @PostMapping("/{candid}")
    public Experience createExperience(@PathVariable(value = "candid") Long candid, @Valid @RequestBody Experience experience) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            experience.setCandidateUser(user);
            return experienceRepository.save(experience);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }
}
