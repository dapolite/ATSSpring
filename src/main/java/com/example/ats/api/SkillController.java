package com.example.ats.api;

import com.example.ats.model.CandidateResume;
import com.example.ats.model.Skill;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.SkillRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skill")
public class SkillController{

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    CandidateUserRepository candidateUserRepository;

    @GetMapping
    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }

    @PostMapping("/{candid}")
    public Skill createSkill(@PathVariable (value = "candid") Long candid, @Valid @RequestBody Skill skill) throws Exception{
        return candidateUserRepository.findById(candid).map(user -> {
            skill.setCandidateUser(user);
            return skillRepository.save(skill);
        }).orElseThrow(() -> new ResourceNotFoundException("CandidateId " + candid + " not found"));
    }
}