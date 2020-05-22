package com.lsh.config;

import com.lsh.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    SessionRegistry sessionRegistry;

    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    @Bean
    UserDetailsService customUserService() { return new CustomUserService();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/assets/**","/js/**").permitAll()
                .antMatchers("/f/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/a/login")
                .defaultSuccessUrl("/a/index")
                .failureUrl("/a/login")
                // session
                .and().sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(sessionRegistry)
                .and().and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }
}
