package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.AddEventDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.EventViewDTO;
import bg.softuni.BarrelWineCornerApp.service.EventService;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @GetMapping()
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("events");
        List<EventViewDTO> events = eventService.getAll();
        modelAndView.addObject("allEvents", events);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {
        ModelAndView modelAndView = new ModelAndView("add-event");

        if (!model.containsAttribute("addEventDTO")) {
            model.addAttribute("addEventDTO", new AddEventDTO());
        }

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid AddEventDTO addEventDTO,
                            BindingResult bindingResult,
                            RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addEventDTO", addEventDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addEventDTO", addEventDTO);
        } else {
            eventService.addEvent(addEventDTO);
        }

        return new ModelAndView("redirect:/events");
    }
}
