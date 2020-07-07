package com.example.ats.api;

import com.example.ats.model.CandidateResume;
import com.example.ats.model.JobPost;
import com.example.ats.model.RecruiterUser;
import com.example.ats.model.Skill;
import com.example.ats.repository.CandidateUserRepository;
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
@CrossOrigin(origins = "*")
@RequestMapping("/api/jobspost")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    CandidateUserRepository candidateUserRepository;

    @Autowired
    RecruiterUserRepository recruiterUserRepository;

    @GetMapping
    public List<JobPost> getAllPost(){
        return jobPostRepository.findAll();
    }

    @GetMapping("/find")
    public List<JobPost> getByType(@RequestParam("jobtypename") String jobtypename,String jobcity,String jobstate,String jobcountry){
        return jobPostRepository.findByjobtypename(jobtypename,jobcity,jobstate,jobcountry);
    }

    @GetMapping("/search")
    public List<JobPost> SearchJobName(@RequestParam("search") String search){
        return jobPostRepository.SearchJob(search);
    }

    @GetMapping("/{jobid}")
    public JobPost getJobPostById(@PathVariable(value = "jobid") Long jobid) {
        return jobPostRepository.findById(jobid)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobid));
    }

    @PostMapping("/{recid}")
    public JobPost createPost(@PathVariable (value = "recid") Long recid, @Valid @RequestBody JobPost jobPost) throws Exception{
        return recruiterUserRepository.findById(recid).map(user -> {
            jobPost.setRecruiterUser(user);
            return jobPostRepository.save(jobPost);
        }).orElseThrow(() -> new ResourceNotFoundException("RecruiterId " + recid + " not found"));
    }

    @PutMapping("/jobs/{id}")
    public void updateJobPost(
            @PathVariable(value = "id") Long jobId, @Valid @RequestBody JobPost jobPost)
            throws ResourceNotFoundException {
        JobPost job =
                jobPostRepository
                        .findById(jobId)
                        .orElseThrow(() -> new ResourceNotFoundException("JobPost not found on :: " + jobId));
        job.setJobLocations(jobPost.getJobLocations());
        job.setJobpostdeadline(jobPost.getJobpostdeadline());
        job.setJobpostjobdesc(jobPost.getJobpostjobdesc());
        job.setJobpostbenefits(jobPost.getJobpostbenefits());
        job.setJobpostcategory(jobPost.getJobpostcategory());
        job.setJobpostexperience(jobPost.getJobpostexperience());
        job.setJobpostqualification(jobPost.getJobpostqualification());
        job.setJobpostresponsibilities(jobPost.getJobpostresponsibilities());
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
