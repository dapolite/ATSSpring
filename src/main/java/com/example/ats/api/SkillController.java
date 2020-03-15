package com.example.ats.api;

import com.example.ats.model.Skill;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class SkillController{

    @Autowired
    private SkillRepository skillRepo;

    @Autowired
    private CandidateUserRepository candidateUserRepository;

    @PostMapping("/{candidateId}/skill")
    public void createSkill(@PathVariable (value = "candidateId") @Valid @RequestBody Long candidateId, Skill skill) throws Exception {

        if(skill.getSkillName() == null){
            throw new Exception("Name Not Found");
        }

//        candidateUserRepository.findById(candidateId).map(user -> {
//            skill.setCandidateUser(user);
//            return skillRepo.save(skill);
//        });
    }


    @GetMapping("/skilllist")
    public List<Skill> getAllSkills(){
        return skillRepo.findAll();
    }
}