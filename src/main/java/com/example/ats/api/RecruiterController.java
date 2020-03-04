package com.example.ats.api;

import com.example.ats.model.Recruiter;
import com.example.ats.repository.RecruiterRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RecruiterController {


    @Autowired
    private RecruiterRepository recruiterRepository;

    @RequestMapping("/homerec")
    public String home(){
        return "Hello9";
    }

    @GetMapping("/recruiterlist")
    public List<Recruiter> getAllRecruiter(){
        return recruiterRepository.findAll();
    }


    @GetMapping("/recruiter/{recid}")
    public void getRecruiterById(@PathVariable(value = "id") Long recId) {
        recruiterRepository.findById(recId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recId));
    }

    @PostMapping("/recruiter")
    public void createRecruiter(@Valid @RequestBody Recruiter recruiter) {
        recruiterRepository.save(recruiter);
    }

    @PutMapping("/recruiter/{id}")
    public void updateRecruiter(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Recruiter recruiterdet)
            throws ResourceNotFoundException {
        Recruiter recruiter =
                recruiterRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + userId));
        recruiter.setCompanyname(recruiterdet.getCompanyname());
        recruiter.setCompanyaddress(recruiterdet.getCompanyaddress());
        recruiter.setCompanydesc(recruiterdet.getCompanydesc());
        recruiter.setCompanyestdate(recruiterdet.getCompanyestdate());
        recruiter.setCompanywebsite(recruiterdet.getCompanywebsite());
        recruiter.setCompanylogo(recruiterdet.getCompanylogo());
        recruiter.setIndustryid(recruiterdet.getIndustryid());
        recruiterRepository.save(recruiter);
    }


    @DeleteMapping("/recruiter/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long recruiterId) throws Exception {
        Recruiter recruiter =
                recruiterRepository
                        .findById(recruiterId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + recruiterId));
        recruiterRepository.delete(recruiter);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
