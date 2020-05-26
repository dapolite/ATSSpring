package com.example.ats.api;

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
@CrossOrigin("*")
@RequestMapping("/api/Recruiter")
public class RecruiterUserController {

    @Autowired
    private RecruiterUserRepository recruiterRepository;


    @GetMapping("/recruiterlist")
    public List<RecruiterUser> getAllRecruiters(){
        return recruiterRepository.findAll();
    }


    @GetMapping("/{recid}")
    public RecruiterUser getRecruiterById(@PathVariable(value = "recid") Long recid) {
        return recruiterRepository.findById(recid)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recid));
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void createRecruiter(@Valid @RequestBody RecruiterUser recruiteruser) {
        recruiterRepository.save(recruiteruser);
    }

    @PutMapping("/{id}")
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
        recruiter.setCompanypic(recruiter.getCompanypic());
        recruiterRepository.save(recruiter);
    }


    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long recruiterId) throws Exception {
        RecruiterUser recruiter =
                recruiterRepository
                        .findById(recruiterId)
                        .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found on :: " + recruiterId));
        recruiterRepository.delete(recruiter);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
