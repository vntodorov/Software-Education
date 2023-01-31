package bg.battle.service;

import bg.battle.model.DTOs.UserLoginDTO;
import bg.battle.model.DTOs.UserRegisterDTO;
import bg.battle.model.User;
import bg.battle.repository.UserRepository;
import bg.battle.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    @Autowired
    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean register(UserRegisterDTO registerDTO){

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            return false;
        }

        Optional<User> byEmail = userRepository.findByEmail(registerDTO.getEmail());

        if (byEmail.isPresent()){
            return false;
        }

        Optional<User> byUsername = userRepository.findByUsername(registerDTO.getUsername());

        if (byUsername.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setFullName(registerDTO.getFullName());
        user.setPassword(registerDTO.getPassword());

        this.userRepository.save(user);

        return true;

    }

    public boolean login(UserLoginDTO loginDTO){
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (byUsernameAndPassword.isEmpty()){
            return false;
        }

        this.currentUser.login(byUsernameAndPassword.get());

        return true;
    }

    public void logout(){
        currentUser.logout();
    }


}
