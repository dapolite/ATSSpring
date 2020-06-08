package com.example.ats.Principal;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.CandidateUserDetails;
import com.example.ats.service.CandidateUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

public class CandidateUserPrincipal implements UserDetails {

    private String username;
    private String password;
    CandidateUser user;


    public CandidateUserPrincipal(CandidateUser user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        System.out.println(password);
        return password;
    }

    @Override
    public String getUsername() {
        System.out.println(username);
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
