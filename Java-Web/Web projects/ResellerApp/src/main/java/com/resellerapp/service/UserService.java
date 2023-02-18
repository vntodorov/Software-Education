package com.resellerapp.service;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegisterDTO;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final OfferService offerService;

    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, OfferService offerService, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.offerService = offerService;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }


    public void register(UserRegisterDTO registerDTO) {
        User userToRegister = new User();
        userToRegister.setUsername(registerDTO.getUsername());
        userToRegister.setEmail(registerDTO.getEmail());
        userToRegister.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(userToRegister);

    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> byUsername = userRepository.findByUsername(loginDTO.getUsername());

        if (byUsername.isEmpty()) {
            return false;
        }

        boolean passwordMatches = passwordEncoder.matches(loginDTO.getPassword(), byUsername.get().getPassword());

        if (!passwordMatches){
            return false;
        }

        this.loggedUser.login(byUsername.get());

        return true;
    }

    public void logout(){
        this.loggedUser.logout();
    }

    public boolean isLoggedIn(){
        return loggedUser.getId() > 0;
    }

    public void removeOffer(Long offerId) {
        offerService.removeOffer(offerId);
    }

    public long getLoggedUserId() {
        return loggedUser.getId();
    }
}
