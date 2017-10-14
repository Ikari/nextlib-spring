package com.next.library;

import com.next.library.service.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author roger
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    SecUserDetailsService service;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/css/**", "/index").permitAll()
        //.antMatchers("/produtos/**").hasRole("USER")
        .and()
        .formLogin()
                .loginPage("/login")
                .failureUrl("/login/login-error")
                .defaultSuccessUrl("/produtos/#")
                .usernameParameter("username")
                .passwordParameter("password")
        ;
    }
    
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }
}
