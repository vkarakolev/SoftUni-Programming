package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.ActionProductDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ProductViewDTO;
import bg.softuni.BarrelWineCornerApp.model.enums.ProductType;
import bg.softuni.BarrelWineCornerApp.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ModelAndView products(Model model) {

        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductViewDTO> products = productService.getAll();
        modelAndView.addObject("allProducts", products);
        modelAndView.addObject("productTypes", ProductType.values());

        if (!model.containsAttribute("actionProductDTO")) {
            model.addAttribute("actionProductDTO", new ActionProductDTO());
        }

        return modelAndView;
    }

    @PostMapping("/products")
    public ModelAndView products(@Valid ActionProductDTO actionProductDTO,
                               BindingResult bindingResult,
                               RedirectAttributes rAtt) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("actionProductDTO", actionProductDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.actionProductDTO", actionProductDTO);
            modelAndView.setViewName("redirect:/products");
        } else {
            productService.addProduct(actionProductDTO);
            modelAndView.setViewName("redirect:/products");
        }

        return modelAndView;
    }

    @GetMapping("/products/edit/{id}")
    public ModelAndView edit(@PathVariable("id")Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit-product");
        modelAndView.addObject("product", productService.getById(id));
        modelAndView.addObject("productTypes", ProductType.values());
        model.addAttribute("actionProductDTO", new ActionProductDTO());

        return modelAndView;
    }

//    TODO: PUT MAPPING, DELETE MAPPING
}
