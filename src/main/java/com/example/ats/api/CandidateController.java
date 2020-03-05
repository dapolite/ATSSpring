package com.example.ats.api;

import com.example.ats.model.Candidate;
import com.example.ats.repository.CandidateRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidatedetails")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @RequestMapping("/homecan")
    public String home(){
        return "Hello9";
    }

    @GetMapping("/candidatelist")
    public List<Candidate> getAllCandidates(){
        return candidateRepository.findAll();
    }

/*    @GetMapping("/searchcandidate")
    public Page<Candidate> findCustomersByFirstName(
            @RequestParam("firstName") String cname,
            Pageable pageable) {

        if (cname == null) {
            return candidateRepository.findAll(pageable);
        } else {
            return candidateRepository.findByName(cname, pageable);
        }
    }*/


    @GetMapping("/candidatedetails/{canid}")
    public void getCandidateById(@PathVariable(value = "id") Long canId) {
        candidateRepository.findById(canId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", canId));
    }

    @PostMapping("/candidatedetails")
    public void createCandidate(@Valid @RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @PutMapping("/candidatedetails/{id}")
    public void updateCandidate(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Candidate candidaterdet)
            throws ResourceNotFoundException {
        Candidate candidate =
                candidateRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + userId));
        candidateRepository.save(candidate);
    }


    @DeleteMapping("/candidatedetails/{id}")
    public Map<String, Boolean> deleteCandidate(@PathVariable(value = "id") Long candidateId) throws Exception {
        Candidate candidate =
                candidateRepository
                        .findById(candidateId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + candidateId));
        candidateRepository.delete(candidate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
