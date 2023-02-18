package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferDTO;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OfferController {

    private final OfferService offerService;

    private final UserService userService;

    @Autowired
    public OfferController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @ModelAttribute("offerDTO")
    public OfferDTO offerDTO(){
        return new OfferDTO();
    }

    @GetMapping("/offers/add")
    public String addOffer(){
        if (!userService.isLoggedIn()){
            return "redirect:/";
        }
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid OfferDTO offerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("offerDTO", offerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDTO", bindingResult);

            return "redirect:/offers/add";
        }

        offerService.addOffer(offerDTO);

        return "redirect:/home";

    }


}
