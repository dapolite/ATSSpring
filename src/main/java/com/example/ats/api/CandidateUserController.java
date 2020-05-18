package com.example.ats.api;

//import com.example.ats.model.Candidate;
import com.example.ats.model.CandidateUser;
//import com.example.ats.repository.CandidateRepository;
import com.example.ats.repository.CandidateUserESRepository;
import com.example.ats.repository.CandidateUserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidates")
public class CandidateUserController {

    @Autowired
    private CandidateUserRepository candidateRepository;

    @Autowired
    private CandidateUserESRepository candidateUserESRepository;

    @RequestMapping("/homecan")
    public String home(){
        return "Hello9";
    }

//    @GetMapping("/candidatelist")
//    public Iterable<CandidateUser> getAllCandidates(){
//        return candidateRepository.findAll();
//    }

    @GetMapping("/candidatelist")
    public List<CandidateUser> getAllCandidates(){
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


    @GetMapping("/candidate/{canid}")
    public void getCandidateById(@PathVariable(value = "id") Long canId) {
        candidateRepository.findById(canId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", canId));
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void createCandidate(@Valid @RequestBody CandidateUser candidate) {
        candidateRepository.save(candidate);
    }

    @PutMapping("/candidate/{id}")
    public void updateCandidate(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody CandidateUser candidaterdet)
            throws ResourceNotFoundException {
        CandidateUser candidate =
                candidateRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + userId));
        candidate.setEmail(candidate.getEmail());
        candidate.setPassword(candidate.getPassword());
        candidate.setPhoneno(candidate.getPhoneno());
        candidate.setAccountisactive(candidate.isAccountisactive());
        candidateRepository.save(candidate);
    }


    @DeleteMapping("/candidate/{id}")
    public Map<String, Boolean> deleteCandidate(@PathVariable(value = "id") Long candidateId) throws Exception {
        CandidateUser candidate =
                candidateRepository
                        .findById(candidateId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + candidateId));
        candidateRepository.delete(candidate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
