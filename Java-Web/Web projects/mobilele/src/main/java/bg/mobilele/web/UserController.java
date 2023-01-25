package bg.mobilele.web;

import bg.mobilele.model.dto.UserLoginDTO;
import bg.mobilele.model.dto.UserRegisterDTO;
import bg.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO){

        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO){
        userService.login(userLoginDTO);
        return "redirect:/";

    }
}
