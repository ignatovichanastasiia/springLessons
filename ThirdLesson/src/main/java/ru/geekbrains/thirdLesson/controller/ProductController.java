package ru.geekbrains.thirdLesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.service.ProductService;
import java.util.List;


@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products_by_cost")
    public String findByCost(Model model, @RequestParam("maxCost") int maxCost, @RequestParam("minCost") int minCost){
        List<Product> products = productService.findByCostLessThanEqualAndCostGreaterThanEqual(maxCost,minCost);
        model.addAttribute("productsByCost", products);
        return "products_by_cost";
    }

    @GetMapping("/products/{id}")
    public String getProductInfo(Model model, @PathVariable Long id) {
        if (productService.findById(id).isPresent()) {
            Product product = productService.findById(id).get();
            model.addAttribute("product", product);
            return "product_info";
        }
        return "redirect:/exception";
    }

    @GetMapping("/products/form")
    public String getProductForm(Model model) {
        return "form_add";
    }

    @GetMapping("/exception")
    public String getExceptionPage(Model model) {
        return "exception";
    }

    //TO DO all meth & TESTS!
    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        return "redirect:/products";
    }
}
