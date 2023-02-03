package bg.battle.controllers;

import bg.battle.model.DTOs.ShipDTO;
import bg.battle.model.DTOs.StartBattleDTO;
import bg.battle.service.ShipService;
import bg.battle.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;

    private final CurrentUser currentUser;

    @ModelAttribute("startBattleDTO")
    public StartBattleDTO startBattleDTO(){
        return new StartBattleDTO();
    }

    @Autowired
    public HomeController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String loggedOut(){
        return "index";
    }

    @GetMapping("/home")
    public String loggedIn(Model model){
        long loggedUserId = this.currentUser.getId();
        List<ShipDTO> ownShips = this.shipService.getOwnedShips(loggedUserId);
        List<ShipDTO> enemyShips = this.shipService.getEnemyShips(loggedUserId);
        List<ShipDTO> sortedShips = this.shipService.getSortedShips();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("sortedShips", sortedShips);



        return "home";
    }
}
