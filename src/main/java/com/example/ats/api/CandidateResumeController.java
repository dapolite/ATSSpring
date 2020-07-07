package com.example.ats.api;

import com.example.ats.model.CandidateResume;
import com.example.ats.model.CandidateUser;
import com.example.ats.repository.CandidateResumeRepository;
import com.example.ats.repository.CandidateUserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/{candid}/post")
    public CandidateResume createResume(@PathVariable (value = "candid") Long candid, @Valid @RequestBody CandidateResume candidateResume) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            candidateResume.setCandidateUser(user);
            return candidateResumeRepository.save(candidateResume);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }

    @PutMapping("/{canid}/update")
    public CandidateResume updateCandidateResume(
            @PathVariable(value = "canid") Long canid, @Valid @RequestBody CandidateResume resume)
            throws ResourceNotFoundException {
        CandidateResume candidate =
                candidateResumeRepository
                        .findById(canid)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + canid));
        candidate.setCandidate_fullname(resume.getCandidate_fullname());
        candidate.setCandidate_about(resume.getCandidate_about());
        candidate.setCandidate_address(resume.getCandidate_address());
        candidate.setCandidate_dob(resume.getCandidate_dob());
        candidate.setCandidate_fathername(resume.getCandidate_fathername());
        candidate.setCandidate_mothername(resume.getCandidate_mothername());
        candidate.setCandidate_nationality(resume.getCandidate_nationality());
        CandidateResume updated=candidateResumeRepository.save(candidate);
        return updated;
    }


    @DeleteMapping("/{id}/delete")
    public Map<String, Boolean> deleteCandidateResume(@PathVariable(value = "id") Long candidateId) throws Exception {
        CandidateResume candidate =
                candidateResumeRepository
                        .findById(candidateId)
                        .orElseThrow(() -> new ResourceNotFoundException("Resume not found on :: " + candidateId));
        candidateResumeRepository.delete(candidate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
