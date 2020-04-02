package com.example.ats.api;

import com.example.ats.model.JobLocation;
import com.example.ats.model.JobPost;
import com.example.ats.repository.JobLocationRepository;
import com.example.ats.repository.JobPostRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/jobpost/location")
public class JobLocationController {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    JobLocationRepository jobLocationRepository;

    @PostMapping("/{jobId}")
    public JobLocation createJobLocation(@PathVariable(value = "jobId") @Valid @RequestBody Long jobId, JobLocation jobLocation) throws Exception {
        return jobPostRepository.findById(jobId).map(jobPost -> {
            jobLocation.setJobPost(jobPost);
            return jobLocationRepository.save(jobLocation);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + jobId + " not found"));
    }


    @GetMapping("/joblocationlist")
    public List<JobLocation> getAllJobLocation(){
        return jobLocationRepository.findAll();
    }

    @GetMapping("/{jobid}")
    public void getJobLocationById(@PathVariable(value = "id") Long jobId) {
        jobLocationRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("JobLocation", "id", jobId));
    }

    @PutMapping("/{id}")
    public JobLocation updateJobLocation(
            @PathVariable(value = "id") Long jobId, @Valid @RequestBody JobLocation jobLocation)
            throws ResourceNotFoundException {
        JobLocation jobl =
                jobLocationRepository
                        .findById(jobId)
                        .orElseThrow(() -> new ResourceNotFoundException("JobLocation not found on :: " + jobId));
        jobl.setJoblocation_address(jobl.getJoblocation_address());
        jobl.setJoblocation_city(jobl.getJoblocation_city());
        jobl.setJoblocation_state(jobl.getJoblocation_state());
        jobl.setJoblocation_country(jobl.getJoblocation_country());
        return jobLocationRepository.save(jobLocation);
    }


    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long jobPostId) throws Exception {
        JobPost jobPost =
                jobPostRepository
                        .findById(jobPostId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + jobPostId));
        jobPostRepository.delete(jobPost);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
