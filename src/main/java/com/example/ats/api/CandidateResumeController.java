package com.example.ats.api;

import com.example.ats.model.CandidateResume;
import com.example.ats.repository.CandidateResumeRepository;
import com.example.ats.repository.CandidateUserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/candidateresume")
public class CandidateResumeController
{
    @Autowired
    CandidateResumeRepository candidateResumeRepository;

    @Autowired
    CandidateUserRepository candidateUserRepository;

    @GetMapping
    public List<CandidateResume> getAllResume(){
        return candidateResumeRepository.findAll();
    }

    @PostMapping("/{candid}")
    public CandidateResume createResume(@RequestParam("file") MultipartFile file, @PathVariable (value = "candid") Long candid, @Valid @RequestBody CandidateResume candidateResume) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            candidateResume.setCandidateUser(user);
            return candidateResumeRepository.save(candidateResume);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }
}
