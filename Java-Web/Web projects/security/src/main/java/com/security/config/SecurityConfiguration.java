package com.security.config;

import com.security.repository.UserRepository;
import com.security.service.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity){
        //todo
        return null;
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new AppUserDetailsService(userRepository);
    }

}
