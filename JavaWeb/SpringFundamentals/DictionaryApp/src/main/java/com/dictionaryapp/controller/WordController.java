package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/word")
public class WordController {
    private final LoggedUser loggedUser;
    private final WordService wordService;

    public WordController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("word-add");
    }

    @PostMapping("/add")
    public ModelAndView add(AddWordDTO addWordDTO) {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        boolean isAdded = wordService.add(addWordDTO);
        String view = isAdded ? "redirect:/home" : "add";
        return new ModelAndView(view);
    }

    @DeleteMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") UUID id) {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.remove(id);

        return new ModelAndView("redirect:/home");
    }

    @DeleteMapping("/remove/all")
    public ModelAndView remove() {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.removeAll();

        return new ModelAndView("redirect:/home");
    }
}
