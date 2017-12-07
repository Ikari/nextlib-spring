package com.next.library;

import com.next.library.service.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author roger
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired SecUserDetailsService service;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .httpBasic()
        .and().authorizeRequests()
            .antMatchers("/css/**", "/index").permitAll()
            .antMatchers("/admin/**").hasAuthority("ADMINISTRADOR")
            .antMatchers("/backoffice/**").hasAuthority("ADMINISTRADOR")
            .antMatchers("/relatorio/**").hasAuthority("ADMINISTRADOR")
            .antMatchers("/checkout/**").hasAuthority("USUARIO")
        .and().formLogin()
            .loginPage("/login")
            //.failureUrl("/login/login-error")
            .failureUrl("/login")
            .defaultSuccessUrl("/produtos/#")
            .usernameParameter("email")
            .passwordParameter("password")
        .and().logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
        ;
    }
    
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }
}
