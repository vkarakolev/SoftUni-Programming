package com.resellerapp.controller;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegistrationDTO;
import com.resellerapp.service.UserService;
import com.resellerapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute("userLoginDTO")UserLoginDTO userLoginDTO,
                              BindingResult bindingResult,
                              RedirectAttributes rAtt) {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if(bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userLoginDTO", userLoginDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);

            return new ModelAndView("redirect:/login");
        }

        boolean isLogged = userService.login(userLoginDTO);

        String view = isLogged ? "redirect:/home" : "login";

        return new ModelAndView(view);
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
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        userService.logout();
        return new ModelAndView("redirect:/");
    }
}
