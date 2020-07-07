package com.example.ats.api;

//import com.example.ats.model.Candidate;
import com.example.ats.model.CandidateUser;
//import com.example.ats.repository.CandidateRepository;
import com.example.ats.model.JobPost;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.JobPostRepository;
import javassist.NotFoundException;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/api/Candidate")
public class CandidateUserController {

    @Autowired
    private CandidateUserRepository candidateRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @CrossOrigin(origins = "*")
    @GetMapping("/CandidateLogin")
    public String printWelcome(ModelMap model, Principal principal ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        model.addAttribute("username", name);
        return "Hello9";
    }

    @GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login?logout";
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


    @GetMapping("/get/{id}")
    public CandidateUser getCandidateById(@PathVariable(value = "id") Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
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


    @PutMapping("/{id}/update")
    public CandidateUser updateCandidate(
            @PathVariable(value = "id") Long id, @Valid @RequestBody CandidateUser candidatedetails)
            throws ResourceNotFoundException {
        CandidateUser candidate =
                candidateRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + id));
        candidate.setCandidate_about(candidatedetails.getCandidate_about());
        candidate.setCandidate_address(candidatedetails.getCandidate_address());
        candidate.setCandidate_fname(candidatedetails.getCandidate_fname());
        candidate.setCandidate_lname(candidatedetails.getCandidate_lname());
        candidate.setEmail(candidatedetails.getEmail());
        candidate.setPassword(candidatedetails.getPassword());
        candidate.setPhoneno(candidatedetails.getPhoneno());
        CandidateUser updated=candidateRepository.save(candidate);
        return updated;
    }


    @DeleteMapping("/{id}/delete")
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
