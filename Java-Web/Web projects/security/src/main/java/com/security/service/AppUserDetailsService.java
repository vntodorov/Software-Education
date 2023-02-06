package com.security.service;

import com.security.model.entity.UserEntity;
import com.security.model.entity.UserRoleEntity;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository
                .findByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found"));

    }

    private UserDetails map(UserEntity userEntity) {
        return
                User.builder()
                        .username(userEntity.getEmail())
                        .password(userEntity.getPassword())
                        .authorities(userEntity.getUserRoles()
                                .stream()
                                .map(this::map)
                                .toList())
                        .build();

    }

    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole
                .getUserRole()
                .name());
    }
}
