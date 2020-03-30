package com.example.ats.api;

import com.example.ats.model.JobPost;
import com.example.ats.model.RecruiterUser;
import com.example.ats.model.Skill;
import com.example.ats.repository.JobPostRepository;
import com.example.ats.repository.RecruiterUserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobspost")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    RecruiterUserRepository recruiterUserRepository;

    @GetMapping
    public List<JobPost> getAllJobs(){
        return jobPostRepository.findAll();
    }

    @GetMapping("/{jobid}")
    public void getJobById(@PathVariable(value = "id") Long jobId) {
        jobPostRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("JobPost", "id", jobId));
    }

    @PostMapping("/{recid}")
    public JobPost createJob(@PathVariable (value = "recid") Long recid, @Valid @RequestBody  JobPost jobPost) throws Exception {

       return recruiterUserRepository.findById(recid).map(user -> {
            jobPost.setRecruiterUser(user);
            return jobPostRepository.save(jobPost);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + recid + " not found"));
    }


    @PutMapping("/jobs/{id}")
    public void updateJobPost(
            @PathVariable(value = "id") Long jobId, @Valid @RequestBody JobPost jobPost)
            throws ResourceNotFoundException {
        JobPost job =
                jobPostRepository
                        .findById(jobId)
                        .orElseThrow(() -> new ResourceNotFoundException("JobPost not found on :: " + jobId));
        job.setJobLocation(job.getJobLocation());
        job.setJobpostduration(job.getJobpostduration());
        job.setJobpostjobdesc(job.getJobpostjobdesc());
        jobPostRepository.save(jobPost);
    }


    @DeleteMapping("/job/{id}")
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
