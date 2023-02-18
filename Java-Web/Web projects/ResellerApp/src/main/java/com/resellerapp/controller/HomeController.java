package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferDTO;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;

    private final OfferService offerService;

    @Autowired
    public HomeController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;
    }

    @GetMapping("/home")
    public String home(Model model){
        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        long loggedUserId = this.userService.getLoggedUserId();
        List<OfferDTO> madeOffers = this.offerService.getMadeOffers(loggedUserId);
        List<OfferDTO> boughtOffers = this.offerService.getBoughtOffers(loggedUserId);
//        List<OfferDTO> otherOffers = this.offerService.getOtherOffers(loggedUserId);

        model.addAttribute("madeOffers", madeOffers);
        model.addAttribute("boughtOffers", boughtOffers);
//        model.addAttribute("otherOffers", otherOffers);

        return "home";
    }


    @GetMapping("/")
    public String loggedOut(){
        if (userService.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("home/remove/{id}")
    public String removeOffer(@PathVariable("id") Long id){
        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }
        this.userService.removeOffer(id);
        return "redirect:/home";

    }
}
