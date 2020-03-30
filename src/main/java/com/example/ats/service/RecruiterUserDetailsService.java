package com.example.ats.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ats.model.RecruiterUser;
import com.example.ats.model.RecruiterUserDetails;
import com.example.ats.repository.RecruiterUserRepository;

@Service
public class RecruiterUserDetailsService implements UserDetailsService {

    @Autowired
    RecruiterUserRepository userRepository;

    @Override
    public RecruiterUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<RecruiterUser> users = userRepository.findByUserName(username);
        users.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return users.map(RecruiterUserDetails::new).get();
    }
}
