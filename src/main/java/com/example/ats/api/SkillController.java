package com.example.ats.api;

import com.example.ats.model.CandidateResume;
import com.example.ats.model.Experience;
import com.example.ats.model.Skill;
import com.example.ats.repository.CandidateUserRepository;

import com.example.ats.repository.SkillRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/skill")
public class SkillController{

    @Autowired
    SkillRepository skillRepository;


    @Autowired
    CandidateUserRepository candidateUserRepository;


    ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping
    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }

    @PostMapping("/{candidateId}/post")
    public Skill createSkill(@PathVariable (value = "candidateId") Long candidateId,
                                 @Valid @RequestBody Skill skill) {
        return candidateUserRepository.findById(candidateId).map(user -> {
            candidateUserRepository.findById(candidateId);
            skill.setCandidateUser(user);
            return skillRepository.save(skill);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + candidateId + " not found"));
    }

    @PutMapping("/{id}/update")
    public Skill updateSkill(
            @PathVariable(value = "id") Long id, @Valid @RequestBody Skill skilldetails)
            throws ResourceNotFoundException {
        Skill candidate =
                skillRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Education not found on :: " + id));
        candidate.setSkillName(skilldetails.getSkillName());
        Skill updated=skillRepository.save(candidate);
        return updated;
    }


    @DeleteMapping("/{id}/delete")
    public Map<String, Boolean> deleteSkill(@PathVariable(value = "id") Long skillId) throws Exception {
        Skill skill =
                skillRepository
                        .findById(skillId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + skillId));
        skillRepository.delete(skill);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}