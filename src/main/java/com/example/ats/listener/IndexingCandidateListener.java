package com.example.ats.listener;

import com.example.ats.model.CandidateUser;
import com.example.ats.repository.CandidateUserESRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;

@Component
public class IndexingCandidateListener implements ApplicationContextAware {

        private static ApplicationContext applicationContext;

        public void setApplicationContext(final ApplicationContext context) throws BeansException {
            applicationContext = context;
        }

        @PostUpdate
        @PostPersist
        public void putToEs(CandidateUser candidateUser){
            System.out.println("************ Indexing Author to ES ************");
            CandidateUserESRepository candidateUserESRepository = applicationContext.getBean(CandidateUserESRepository.class);

            if(candidateUser != null) {
                candidateUserESRepository.findAll();
                candidateUserESRepository.save(candidateUser);
                System.out.println(candidateUser.toString());
            }

        }

        @PreRemove
        public void removeFromEs(CandidateUser candidateUser){
            System.out.println("************ Remove deleted Author from ES ************");
            CandidateUserESRepository candidateUserESRepository = applicationContext.getBean(CandidateUserESRepository.class);

            if(candidateUser != null && candidateUserESRepository.findById(candidateUser.getUserId()) != null) {
                candidateUserESRepository.delete(candidateUser);
                System.out.println(candidateUser.toString());
            }
        }
    }

