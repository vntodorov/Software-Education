package bg.pathfinder.pathfinder.web;

import bg.pathfinder.pathfinder.model.DTO.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

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
    public String doRegister(@Valid UserRegisterDTO userRegisterDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        System.out.println(userRegisterDTO);

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.BindingResult.userRegistrationDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }
}
