package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.ActionPartnerDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.PartnerViewDTO;
import bg.softuni.BarrelWineCornerApp.service.PartnerService;
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
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping()
    public ModelAndView get(Model model) {
        ModelAndView modelAndView = new ModelAndView("partners");
        List<PartnerViewDTO> partners = partnerService.getAll();
        modelAndView.addObject("allPartners", partners);

        if (!model.containsAttribute("actionPartnerDTO")) {
            model.addAttribute("actionPartnerDTO", new ActionPartnerDTO());
        }

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid ActionPartnerDTO actionPartnerDTO,
                            BindingResult bindingResult,
                            RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("actionPartnerDTO", actionPartnerDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.actionPartnerDTO", actionPartnerDTO);
        } else {
            partnerService.addPartner(actionPartnerDTO);
        }

        return new ModelAndView("redirect:/partners");
    }
}
