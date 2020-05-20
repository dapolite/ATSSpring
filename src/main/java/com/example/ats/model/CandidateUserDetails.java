package com.example.ats.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateUserDetails implements UserDetails {



    private String userName;
    private String password;
    private Boolean accountisactive;
    private List<GrantedAuthority> authorities;

    public CandidateUserDetails(CandidateUser users) {
        this.userName=users.getUsername();
        this.password=users.getPassword();
        this.accountisactive=users.isAccountisactive();
//        this.authorities=Arrays.stream(users.getUsertype().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public CandidateUserDetails(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return accountisactive;
    }
}
