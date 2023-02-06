package com.security.config;

import com.security.model.enums.UserRoleEnum;
import com.security.repository.UserRepository;
import com.security.service.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.
                        authorizeHttpRequests().
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                        requestMatchers("/", "/users/login", "/users/register").permitAll().
                        requestMatchers("/pages/moderators").hasRole(UserRoleEnum.MODERATOR.name()).
                        requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name()).
                        anyRequest().
                authenticated().
                and().
                        formLogin().
                        loginPage("/users/login").
                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                        defaultSuccessUrl("/").
                        failureForwardUrl("/users/login-error").
                and().
                        logout().
                        logoutUrl("/users/logout").
                        invalidateHttpSession(true).
                deleteCookies("JSESSIONID");


        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AppUserDetailsService(userRepository);
    }


}