package bg.battle.controllers;

import bg.battle.model.DTOs.CreateShipDTO;
import bg.battle.service.AuthService;
import bg.battle.service.ShipService;
import bg.battle.session.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipService;

    private final AuthService authService;

    @Autowired
    public ShipController(ShipService shipService, AuthService authService) {
        this.shipService = shipService;
        this.authService = authService;
    }

    @ModelAttribute("shipDTO")
    public CreateShipDTO shipDTO(){
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String addShip(){
        if (!authService.isLoggedIn()) {
            return "redirect:/";
        }

        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String addShip(@Valid CreateShipDTO shipDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !this.shipService.createShip(shipDTO)){

            redirectAttributes.addFlashAttribute("shipDTO", shipDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipDTO", bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";

    }
}
