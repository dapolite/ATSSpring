package com.example.ats.api;

import com.example.ats.model.Recruiter;
import com.example.ats.model.RecruiterUser;
import com.example.ats.repository.RecruiterUserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterUserController {

    @Autowired
    private RecruiterUserRepository recruiterRepository;

    @RequestMapping("/homerec")
    public String home(){
        return "Hello9";
    }

    @GetMapping
    public List<RecruiterUser> getAllRecruiters(){
        return recruiterRepository.findAll();
    }


    @GetMapping("/{recid}")
    public RecruiterUser getRecruiterById(@PathVariable(value = "recid") Long recid) {
        return recruiterRepository.findById(recid)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recid));
    }

    @PostMapping("/recruiter")
    public void createRecruiter(@Valid @RequestBody RecruiterUser recruiteruser) {
        recruiterRepository.save(recruiteruser);
    }

    @PutMapping("/recruiter/{id}")
    public void updateRecruiter(
            @PathVariable(value = "id") Long id, @Valid @RequestBody RecruiterUser recruiteruser)
            throws ResourceNotFoundException {
        RecruiterUser recruiter =
                recruiterRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " +id));
        recruiter.setEmail(recruiter.getEmail());
        recruiter.setPassword(recruiter.getPassword());
        recruiter.setPhoneno(recruiter.getPhoneno());
        recruiter.setAccountisactive(recruiter.isAccountisactive());
        recruiterRepository.save(recruiter);
    }


    @DeleteMapping("/recruiter/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long recruiterId) throws Exception {
        RecruiterUser recruiter =
                recruiterRepository
                        .findById(recruiterId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + recruiterId));
        recruiterRepository.delete(recruiter);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
