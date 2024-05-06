package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.UserRegisterDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.UserRoleDTO;
import bg.softuni.BarrelWineCornerApp.model.enums.Role;
import bg.softuni.BarrelWineCornerApp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("allUsers", userService.getAll());
        modelAndView.addObject("roles", Role.values());
        modelAndView.addObject("userRoleDTO", new UserRoleDTO());

        return modelAndView;
    }

    @PutMapping("/update/{id}")
    public ModelAndView update(UserRoleDTO userRoleDTO) {
        userService.updateRole(userRoleDTO);

        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("roles", Role.values());

        if(!model.containsAttribute("userRegisterDTO")){
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        }

        return (modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegisterDTO userRegisterDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes rAtt) {

        final ModelAndView modelAndView = new ModelAndView("register");

        if(bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDTO", userRegisterDTO);
            modelAndView.setViewName("redirect:/users/register");
        } else {
            userService.register(userRegisterDTO);
            modelAndView.setViewName("redirect:/users/login");
        }

        return modelAndView;
    }
}