package com.example.ats.api;

import com.example.ats.model.JobLocation;
import com.example.ats.model.JobPost;
import com.example.ats.model.JobType;
import com.example.ats.repository.JobPostRepository;
import com.example.ats.repository.JobTypeRepository;
import com.example.ats.repository.RecruiterUserRepository;
import org.apache.coyote.Response;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/jobspost/type")
public class JobTypeController {

    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    RecruiterUserRepository recruiterUserRepository;

    @Autowired
    JobPostRepository jobPostRepository;

    @PostMapping("/{jobId}")
    public JobType createJobType(@PathVariable(value = "jobId") Long jobId, @Valid @RequestBody JobType jobType) throws Exception {
        return jobPostRepository.findById(jobId).map(jobPost -> {
            jobType.setJobPost(jobPost);
            return jobTypeRepository.save(jobType);

        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + jobId + " not found"));
    }

    @PutMapping("/{id}")
    public JobType updateJobType(
            @PathVariable(value = "id") Long jobId, @Valid @RequestBody JobType jobType)
            throws ResourceNotFoundException {
        JobType jobt=
                jobTypeRepository
                        .findById(jobId)
                        .orElseThrow(() -> new ResourceNotFoundException("JobLocation not found on :: " + jobId));
        jobt.setJobtypename(jobt.getJobtypename());
        jobt.setJobPost(jobt.getJobPost());
        return jobTypeRepository.save(jobType);
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
