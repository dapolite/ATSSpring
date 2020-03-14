package com.example.ats.api;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.Skill;
import com.example.ats.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class SkillController{

    @Autowired
    private SkillRepository skillRepository;

    @PostMapping("/skill")
    public void createSkill(@Valid @RequestBody Skill skill) {
        skillRepository.save(skill);
    }


    @GetMapping("/skilllist")
    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }
}

