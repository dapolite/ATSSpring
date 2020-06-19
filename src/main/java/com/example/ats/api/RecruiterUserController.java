package com.example.ats.api;

import com.example.ats.model.RecruiterUser;
import com.example.ats.repository.RecruiterUserRepository;
import javassist.NotFoundException;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/Recruiter")
public class RecruiterUserController {

    @Autowired
    private RecruiterUserRepository recruiterRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @CrossOrigin(origins = "*")
    @GetMapping("/homerec")
    public String printWelcome(ModelMap model, Principal principal ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        model.addAttribute("username", name);
        return "Hello9";
    }

    @GetMapping("/recruiterlist")
    public List<RecruiterUser> getAllRecruiters(){
        return recruiterRepository.getRecData();
    }

    @GetMapping("{recid}")
    public RecruiterUser getRecruiterById(@PathVariable(value = "recid") Long recid) {
        return recruiterRepository.findById(recid)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recid));
    }

    @GetMapping("/{username}")
    public RecruiterUser getRecruiterByUserName(@PathVariable(value = "username") String username) throws NotFoundException {
        return recruiterRepository.findUsersByRecruiterUsername(username);
    }

    @GetMapping("/getId/{username}")
    public Long getRecruiterUserId(@PathVariable(value = "username") String username) throws NotFoundException {
        return recruiterRepository.findUserIdByRecruiterUsername(username);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void createRecruiter(@Valid @RequestBody RecruiterUser recruiteruser) {
        String encodedPassword = bCryptPasswordEncoder.encode(recruiteruser.getPassword());
        recruiteruser.setPassword(encodedPassword);
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
