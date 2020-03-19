package com.example.ats.api;

import com.example.ats.model.JobLocation;
import com.example.ats.model.Skill;
import com.example.ats.repository.JobLocationRepository;
import com.example.ats.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("api/JobPost/Location")
public class JobLocationController {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    JobLocationRepository jobLocationRepository;

    @PostMapping("/{jobId}/location")
    public void createJobLocation(@PathVariable(value = "jobId") @Valid @RequestBody Long jobId, JobLocation jobLocation) throws Exception {


        jobPostRepository.findById(jobId).map(jobPost -> {
            jobLocation.setJobPost(jobPost);
            return jobLocationRepository.save(jobLocation);
        });
    }


    @GetMapping("/joblocationlist")
    public List<JobLocation> getAllSkills(){
        return jobLocationRepository.findAll();
    }
}
