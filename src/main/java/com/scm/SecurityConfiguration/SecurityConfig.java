package com.scm.SecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.serviceImplement.SecurityService;

@Configuration
public class SecurityConfig {
    @Autowired
    SecurityService securityService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        // for Usename
       DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(securityService);
       //forpassword
       authenticationProvider.setPasswordEncoder(passwordEncoder());

       return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

 // for securing routes 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{

        security.authorizeHttpRequests(authorize ->
         authorize.requestMatchers("/user/**").authenticated().anyRequest().permitAll());
         security.formLogin(Customizer.withDefaults());
        return security.build();
    } 
    
}