package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferHomeDTO;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final LoggedUser loggedUser;

    public HomeController(OfferService offerService, LoggedUser loggedUser) {
        this.offerService = offerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index() {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("home");

        OfferHomeDTO offerHomeDTO = offerService.getOffersForHomePage();

        modelAndView.addObject("offerHomeDTO", offerHomeDTO);

        return modelAndView;
    }
}
