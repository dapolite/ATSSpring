package com.example.ats.api;

import com.example.ats.model.CandidateResume;
import com.example.ats.model.Skill;
import com.example.ats.repository.CandidateUserESRepository;
import com.example.ats.repository.CandidateUserRepository;
import com.example.ats.repository.SkillESRepository;
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
    SkillESRepository skillESRepository;

    @Autowired
    CandidateUserRepository candidateUserRepository;

    @Autowired
    CandidateUserESRepository candidateUserESRepository;

    @GetMapping
    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }

    @PostMapping("/{candidateId}")
    public Skill createSkill(@PathVariable (value = "candidateId") Long candidateId,
                                 @Valid @RequestBody Skill skill) {
        return candidateUserRepository.findById(candidateId).map(user -> {
            skill.setCandidateUser(user);
            System.out.println(user.toString());
            return skillRepository.save(skill);

        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + candidateId + " not found"));
    }
}