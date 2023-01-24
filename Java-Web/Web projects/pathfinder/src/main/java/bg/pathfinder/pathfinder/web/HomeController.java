package bg.pathfinder.pathfinder.web;

import bg.pathfinder.pathfinder.model.Route;
import bg.pathfinder.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final RouteService routeService;

    @Autowired
    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model){
        Route route = routeService.getMostCommented();

        model.addAttribute("mostCommented", route);
        return "index";
    }
}
