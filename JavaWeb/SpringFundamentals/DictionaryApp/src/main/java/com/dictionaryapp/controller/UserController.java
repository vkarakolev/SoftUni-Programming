package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final LoggedUser loggedUser;
    private final UserService userService;

    public UserController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO) {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginDTO") @Valid UserLoginDTO userLoginDTO,
                              BindingResult bindingResult) {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if(bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        boolean hasSuccessfulLogin = userService.login(userLoginDTO);

        if(!hasSuccessfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }



    @GetMapping("/register")
    public ModelAndView register() {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegistrationDTO userRegistrationDTO) {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        boolean isRegistered = userService.register(userRegistrationDTO);

        String view = isRegistered ? "redirect:/login" : "register";

        return new ModelAndView(view);
    }

    @PostMapping("/logout")
    public ModelAndView logout() {
        userService.logout();
        return new ModelAndView("redirect:/");
    }

}
