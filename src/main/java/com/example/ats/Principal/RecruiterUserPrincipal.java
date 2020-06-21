package com.example.ats.Principal;

import com.example.ats.model.CandidateUser;
import com.example.ats.model.RecruiterUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class RecruiterUserPrincipal implements UserDetails {

    private String username;
    private String password;
    RecruiterUser user;
    private boolean isActive;


    public RecruiterUserPrincipal(RecruiterUser user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.isActive = user.isAccountisactive();
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
        return isActive;
    }
}
