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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ModelAndView get(Model model) {

        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductViewDTO> products = productService.getAll();
        modelAndView.addObject("allProducts", products);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {
        ModelAndView modelAndView = new ModelAndView("add-product");
        modelAndView.addObject("productTypes", ProductType.values());

        if (!model.containsAttribute("actionProductDTO")) {
            model.addAttribute("actionProductDTO", new ActionProductDTO());
        }

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid ActionProductDTO actionProductDTO,
                               BindingResult bindingResult,
                               RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("actionProductDTO", actionProductDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.actionProductDTO", actionProductDTO);
        } else {
            productService.addProduct(actionProductDTO);
        }

        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit-product");
        modelAndView.addObject("product", productService.getById(id));
        modelAndView.addObject("productTypes", ProductType.values());
        model.addAttribute("actionProductDTO", new ActionProductDTO());

        return modelAndView;
    }

    @PutMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, @Valid ActionProductDTO actionProductDTO,
                             BindingResult bindingResult, RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("actionProductDTO", actionProductDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.actionProductDTO", actionProductDTO);
        } else {
            productService.editProduct(actionProductDTO, id);
        }

        return new ModelAndView("redirect:/products");
    }

    @DeleteMapping("/remove/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        productService.remove(id);

        return new ModelAndView("redirect:/products");
    }
}
