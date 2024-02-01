package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.AddReservationDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.ReservationViewDTO;
import bg.softuni.BarrelWineCornerApp.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/create")
    public ModelAndView addReservation(Model model) {

        if(!model.containsAttribute("addReservationDTO")){
            model.addAttribute("addReservationDTO", new AddReservationDTO());
        }

        return new ModelAndView("create-reservation");
    }

    @PostMapping("/create")
    public ModelAndView addReservation(@Valid AddReservationDTO addReservationDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes rAtt) {

        final ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addReservationDTO", addReservationDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addReservationDTO", addReservationDTO);
            modelAndView.setViewName("redirect:/create");
        } else {
            reservationService.addReservation(addReservationDTO);
            JOptionPane.showMessageDialog(null,
                    "Thank you for your reservation! Check your email for confirmation!");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView allReservations() {

        List<ReservationViewDTO> reservations = reservationService.getAll();

        ModelAndView modelAndView = new ModelAndView("reservations");
        modelAndView.addObject("reservations", reservations);

        return new ModelAndView("reservations");
    }
}
