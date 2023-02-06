package com.security.service;

import com.security.model.entity.UserEntity;
import com.security.model.entity.UserRoleEntity;
import com.security.model.enums.UserRoleEnum;
import com.security.repository.UserRepository;
import com.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void init() {

        if (userRepository.count() == 0 && userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setUserRole(UserRoleEnum.ADMIN);

            UserRoleEntity moderatorRole = new UserRoleEntity();
            moderatorRole.setUserRole(UserRoleEnum.MODERATOR);

            adminRole = userRoleRepository.save(adminRole);
            moderatorRole = userRoleRepository.save(moderatorRole);

            initAdmin(List.of(adminRole, moderatorRole));
            initModerator(List.of(moderatorRole));
            initUser(List.of());

        }

    }

    private void initAdmin(List<UserRoleEntity> roles) {
        UserEntity admin = new UserEntity();
        admin.setUserRoles(roles);
        admin.setFirstName("Admin");
        admin.setLastName("Adminov");
        admin.setEmail("admin@xample.com");
        admin.setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(admin);
    }

    private void initModerator(List<UserRoleEntity> roles) {
        UserEntity moderator = new UserEntity();
        moderator.setUserRoles(roles);
        moderator.setFirstName("Moderator");
        moderator.setLastName("Moderatorov");
        moderator.setEmail("moderator@xample.com");
        moderator.setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(moderator);

    }

    private void initUser(List<UserRoleEntity> roles) {
        UserEntity user = new UserEntity();
        user.setUserRoles(roles);
        user.setFirstName("User");
        user.setLastName("Userov");
        user.setEmail("user@xample.com");
        user.setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(user);

    }
}
