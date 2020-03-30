package com.example.ats.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.CandidateUserDetails;
import com.example.ats.repository.CandidateUserRepository;

@Service
public class CandidateUserDetailsService implements UserDetailsService {

    @Autowired
    CandidateUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CandidateUser> users = userRepository.findByUserName(username);
        users.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return users.map(CandidateUserDetails::new).get();
    }
}

