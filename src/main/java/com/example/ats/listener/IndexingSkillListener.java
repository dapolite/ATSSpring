/*
package com.example.ats.listener;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.Skill;
import com.example.ats.repository.CandidateUserESRepository;
import com.example.ats.repository.SkillESRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;

@Component
public class IndexingSkillListener implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private CandidateUser candidateUser;

    public void setApplicationContext(final ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    @PostUpdate
    @PostPersist
    public void putToEs(Skill skill){
        System.out.println("************ Indexing Skill to ES ************");
        SkillESRepository skillESRepository = applicationContext.getBean(SkillESRepository.class);
        CandidateUserESRepository candidateUserESRepository=applicationContext.getBean(CandidateUserESRepository.class);

        if(skill != null) {
            skill.setCandidateUser(candidateUser);
            skillESRepository.index(skill);
            skillESRepository.save(skill);
            System.out.println(skill.toString());
        }

    }

    @PreRemove
    public void removeFromEs(Skill skill){
        System.out.println("************ Remove deleted Author from ES ************");
        SkillESRepository skillESRepository = applicationContext.getBean(SkillESRepository.class);

        if(skill != null && skillESRepository.findById(skill.getSkillId()) != null) {
            skillESRepository.delete(skill);
            System.out.println(skill.toString());
        }
    }
}

*/
