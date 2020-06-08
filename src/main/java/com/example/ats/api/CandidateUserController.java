package com.example.ats.api;

//import com.example.ats.model.Candidate;
import com.example.ats.model.CandidateUser;
//import com.example.ats.repository.CandidateRepository;
import com.example.ats.repository.CandidateUserRepository;
import javassist.NotFoundException;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/api/candidates")
public class CandidateUserController {

    @Autowired
    private CandidateUserRepository candidateRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @CrossOrigin(origins = "*")
    @GetMapping("/homecan")
    public String printWelcome(ModelMap model, Principal principal ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        model.addAttribute("username", name);
        return "Hello9";
    }

//    @GetMapping("/candidatelist")
//    public Iterable<CandidateUser> getAllCandidates(){
//        return candidateRepository.findAll();
//    }

    @GetMapping("/candidatelist")
    public List<CandidateUser> getAllCandidates(){
        return candidateRepository.getData();
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

    @GetMapping("/{username}")
    public CandidateUser getCandidateByUserName(@PathVariable(value = "username") String username) throws NotFoundException {
        return candidateRepository.findUsersByCandidateUsername(username);
    }

    @GetMapping("/getId/{username}")
    public Long getCandidateUserId(@PathVariable(value = "username") String username) throws NotFoundException {
        return candidateRepository.findUserIdByCandidateUsername(username);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void createCandidate(@Valid @RequestBody CandidateUser candidate) {
        String encodedPassword = bCryptPasswordEncoder.encode(candidate.getPassword());
        candidate.setPassword(encodedPassword);
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
