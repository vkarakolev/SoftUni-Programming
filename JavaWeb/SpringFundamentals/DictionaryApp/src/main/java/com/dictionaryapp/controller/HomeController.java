package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.HomeWordsDTO;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;

    public HomeController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
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

        ModelAndView home = new ModelAndView("home");

        HomeWordsDTO homeWordsDTO = wordService.getWordsForHome();

        home.addObject("homeWordsDTO", homeWordsDTO);

        return home;
    }
}
