package bg.pathfinder.pathfinder.service;

import bg.pathfinder.pathfinder.model.DTO.UserRegisterDTO;
import bg.pathfinder.pathfinder.model.User;
import bg.pathfinder.pathfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegisterDTO userRegisterDTO){
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byEmail = this.userRepository.findByEmail(userRegisterDTO.getEmail());

        if (byEmail.isPresent()){
            throw new RuntimeException("email.used");
        }

        User user = new User(userRegisterDTO.getUsername(),
                userRegisterDTO.getPassword(),
                userRegisterDTO.getEmail(),
                userRegisterDTO.getFullName(),
                userRegisterDTO.getAge());

        this.userRepository.save(user);
    }
}


