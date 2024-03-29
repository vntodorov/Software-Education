package bg.pathfinder.pathfinder.web;

import bg.pathfinder.pathfinder.model.DTO.UserRegisterDTO;
import bg.pathfinder.pathfinder.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDTO")
    public void initForm(Model model){
        model.addAttribute("userRegistrationDTO", new UserRegisterDTO());
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping( "/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO userRegistrationDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        System.out.println(userRegistrationDTO);

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.BindingResult.userRegistrationDTO", bindingResult);

            return "redirect:/register";
        }

        this.authService.register(userRegistrationDTO);

        return "redirect:/login";
    }
}
