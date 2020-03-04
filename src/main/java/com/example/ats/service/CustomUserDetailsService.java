package com.example.ats.service;

import com.example.ats.model.CustomUserDetails;
import com.example.ats.model.Users;
import com.example.ats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = userRepository.findByUserName(username);
        users.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return users.map(CustomUserDetails::new).get();
    }
}
