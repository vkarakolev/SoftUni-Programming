package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.AddReservationDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ReservationViewDTO;
import bg.softuni.BarrelWineCornerApp.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping()
    public ModelAndView get(Model model) {

        ModelAndView modelAndView = new ModelAndView("reservations");
//        TODO: Role check
        List<ReservationViewDTO> reservations = reservationService.getAll();
        modelAndView.addObject("allReservations", reservations);

        if (!model.containsAttribute("addReservationDTO")) {
            model.addAttribute("addReservationDTO", new AddReservationDTO());
        }

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView create(@Valid AddReservationDTO addReservationDTO,
                                       BindingResult bindingResult,
                                       RedirectAttributes rAtt) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addReservationDTO", addReservationDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addReservationDTO", addReservationDTO);
            modelAndView.setViewName("redirect:/reservations");
        } else {
            reservationService.addReservation(addReservationDTO);
//            TODO: pop up
            rAtt.addFlashAttribute("success",
                    "Thank you for your reservation! Check your email for confirmation!");
            rAtt.addFlashAttribute("alertClass", "alert-success");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @PutMapping("/approve/{id}")
    public ModelAndView approve(@PathVariable("id") Long id) {
        reservationService.approve(id);

        return new ModelAndView("redirect:/reservations");
    }
}
