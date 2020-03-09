package com.example.ats.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.ats.service.CandidateUserDetailsService;
import com.example.ats.service.RecruiterUserDetailsService;

@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
class RecruiterSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RecruiterUserDetailsService recruiterUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(recruiterUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        
        http.requestMatchers().antMatchers("/api/recruiters/**")
        .and()
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .httpBasic();
    }

}

@Configuration
class CandidateSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    CandidateUserDetailsService candidateUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(candidateUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http       //other configure params.
                .csrf().disable();
        http.requestMatchers().antMatchers("/api/candidat")
        .and()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
    }
    
}