package com.au.arvin.spaceshuttle.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/v1/**")
                .authorizeRequests()
                .anyRequest().hasRole("API_USER")
                .and()
                //if we going to keep this method with the SecurityConfiguration(),
                // we have to set a higher priority to SecurityConfiguration(),
                // but this is not the right solution,
                // since this method will never be used.The right solution is to keep only one of them
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("api_user").password("password").roles("API_USER");
    }
}
