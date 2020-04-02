package com.example.ats.api;

import com.example.ats.model.JobPost;
import com.example.ats.model.JobType;
import com.example.ats.repository.JobPostRepository;
import com.example.ats.repository.JobTypeRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobspost/type")
public class JobTypeController {

    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

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
