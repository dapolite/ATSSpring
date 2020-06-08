package com.example.ats.api;

import com.example.ats.model.RecruiterCompany;
import com.example.ats.model.RecruiterUser;
import com.example.ats.repository.RecruiterCompanyRepository;
import com.example.ats.repository.RecruiterUserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/companydetails")
public class RecruiterCompanyController {

    @Autowired
    RecruiterCompanyRepository recruiterCompanyRepository;

    @Autowired
    RecruiterUserRepository recruiterUserRepository;

    @GetMapping
    public List<RecruiterCompany> getAllCompanyDetails(){
        return recruiterCompanyRepository.findAll();
    }

    @PostMapping("/{recid}")
    public RecruiterCompany createCompanyDetails(@PathVariable (value = "recid") Long recid, @Valid @RequestBody
                                                 RecruiterCompany recruiterCompany) throws Exception{
        return recruiterUserRepository.findById(recid).map(user -> {
            recruiterCompany.setRecruiterUser(user);
            return recruiterCompanyRepository.save(recruiterCompany);
        }).orElseThrow(() -> new ResourceNotFoundException("RecruiterId " + recid + " not found"));
    }

//    @PostMapping
//    @CrossOrigin(origins = "*")
//    public void createRecruiterCompany(@Valid @RequestBody RecruiterCompany recruiterCompany) {
//        recruiterCompanyRepository.save(recruiterCompany);
//    }
}
