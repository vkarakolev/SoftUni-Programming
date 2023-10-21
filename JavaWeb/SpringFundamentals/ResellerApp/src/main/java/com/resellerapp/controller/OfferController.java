package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferAddDTO;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final LoggedUser loggedUser;

    public OfferController(OfferService offerService, LoggedUser loggedUser) {
        this.offerService = offerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("offer-add");
    }

    @PostMapping("/add")
    public ModelAndView add(OfferAddDTO offerAddDTO) {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        boolean isAdded = offerService.add(offerAddDTO);
        String view = isAdded ? "redirect:/home" : "add";

        return new ModelAndView(view);
    }

    @PostMapping("/buy/{id}")
    public ModelAndView buy(@PathVariable("id")UUID id) {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        offerService.buy(id);
        return new ModelAndView("redirect:/home");
    }

    @DeleteMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id")UUID id) {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        offerService.remove(id);

        return new ModelAndView("redirect:/home");
    }
}
