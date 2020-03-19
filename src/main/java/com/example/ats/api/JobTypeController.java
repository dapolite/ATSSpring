package com.example.ats.api;

import com.example.ats.model.JobType;
import com.example.ats.model.Skill;
import com.example.ats.repository.JobPostRepository;
import com.example.ats.repository.JobTypeRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/JobPost/type")
public class JobTypeController {

    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

    @PostMapping("/{jobpostId}")
    public JobType createJobType(@PathVariable(value = "jobpostId") Long jobpostId,@Valid @RequestBody  JobType jobType) throws Exception {
        return jobPostRepository.findById(jobpostId).map(jobpost -> {
            jobType.setJobPost(jobpost);
            return jobTypeRepository.save(jobType);
            }).orElseThrow(() -> new ResourceNotFoundException("JobPost " + jobpostId + " not found"));
        }


        @GetMapping("/jobtypelist")
            public List<JobType> getAllSJobType(){
            return jobTypeRepository.findAll();
        }
}
