package com.resellerapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public Pbkdf2PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }
}
