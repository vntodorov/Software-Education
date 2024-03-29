package bg.battle.controllers;

import bg.battle.model.DTOs.UserLoginDTO;
import bg.battle.model.DTOs.UserRegisterDTO;
import bg.battle.service.AuthService;
import bg.battle.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO loginDTO(){
        return new UserLoginDTO();
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO registerDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register(){
        if (authService.isLoggedIn()) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (authService.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || !userService.register(registerDTO)){

            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";

    }

    @GetMapping("/login")
    public String login() {

        if (authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (authService.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        if (!userService.login(loginDTO)){

            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }

        return "redirect:/home";

    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();

        return "redirect:/";
    }
}
