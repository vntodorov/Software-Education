package bg.pathfinder.pathfinder.web;

import bg.pathfinder.pathfinder.model.DTO.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userRegistrationDTO", new UserRegisterDTO());
        return "register";
    }

    @GetMapping( "/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO userRegisterDTO,
                             BindingResult bindingResult){
        System.out.println(userRegisterDTO);
        return "redirect:/login";
    }
}
