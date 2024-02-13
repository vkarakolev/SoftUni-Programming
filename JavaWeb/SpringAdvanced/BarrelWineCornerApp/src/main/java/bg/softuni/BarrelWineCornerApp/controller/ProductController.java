package bg.softuni.BarrelWineCornerApp.controller;

import bg.softuni.BarrelWineCornerApp.model.dto.CreateProductDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ProductViewDTO;
import bg.softuni.BarrelWineCornerApp.model.enums.ProductType;
import bg.softuni.BarrelWineCornerApp.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
        modelAndView.addObject("productTypes", ProductType.getTypes());

        if (!model.containsAttribute("createProductDTO")) {
            model.addAttribute("createProductDTO", new CreateProductDTO());
        }

        return modelAndView;
    }

    @PostMapping("/products")
    public ModelAndView products(@Valid CreateProductDTO createProductDTO,
                               BindingResult bindingResult,
                               RedirectAttributes rAtt) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createProductDTO", createProductDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createProductDTO", createProductDTO);
            modelAndView.setViewName("redirect:/products");
        } else {
            productService.addProduct(createProductDTO);
            modelAndView.setViewName("redirect:/products");
        }

        return modelAndView;
    }
}
