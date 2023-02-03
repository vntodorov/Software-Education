package bg.battle.controllers;

import bg.battle.model.DTOs.StartBattleDTO;
import bg.battle.service.BattleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {

    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDTO startBattleDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("startBattleDTO", startBattleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.startBattleDTO", bindingResult);

            return "redirect:/home";
        }

        this.battleService.attack(startBattleDTO);

        return "redirect:/home";


    }
}
