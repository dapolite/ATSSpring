package com.example.ats.api;

import java.util.List;

import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ats.model.RecruiterUser;
import com.example.ats.repository.RecruiterUserRepository;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

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
    public void getRecruiterById(@PathVariable(value = "id") Long recId) {
        recruiterRepository.findById(recId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recId));
    }

//    @PostMapping("/recruiter")
//    public void createRecruiter(@Valid @RequestBody Recruiter recruiter) {
//        recruiterRepository.save(recruiter);
//    }
//
//    @PutMapping("/recruiter/{id}")
//    public void updateRecruiter(
//            @PathVariable(value = "id") Long userId, @Valid @RequestBody Recruiter recruiterdet)
//            throws ResourceNotFoundException {
//        Recruiter recruiter =
//                recruiterRepository
//                        .findById(userId)
//                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + userId));
//        recruiter.setCompanyname(recruiterdet.getCompanyname());
//        recruiter.setCompanyaddress(recruiterdet.getCompanyaddress());
//        recruiter.setCompanydesc(recruiterdet.getCompanydesc());
//        recruiter.setCompanyestdate(recruiterdet.getCompanyestdate());
//        recruiter.setCompanywebsite(recruiterdet.getCompanywebsite());
//        recruiter.setCompanylogo(recruiterdet.getCompanylogo());
//        recruiter.setIndustryid(recruiterdet.getIndustryid());
//        recruiterRepository.save(recruiter);
//    }
//
//
//    @DeleteMapping("/recruiter/{id}")
//    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long recruiterId) throws Exception {
//        Recruiter recruiter =
//                recruiterRepository
//                        .findById(recruiterId)
//                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + recruiterId));
//        recruiterRepository.delete(recruiter);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}
