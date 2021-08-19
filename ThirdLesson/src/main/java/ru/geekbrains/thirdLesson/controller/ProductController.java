package ru.geekbrains.thirdLesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //работает
    @GetMapping("/products")
    public String getProducts(Model model) {
        HashMap getProducts = productService.getProducts();
        ArrayList products = new ArrayList(productService.getProducts().values());
        model.addAttribute("products", products);
        return "products";
    }

    //работает
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

    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute Product product, Model model) {
        if (productService.add(product.getId(), product)) {
            return "redirect:/products";
        }
        return "redirect:/exception";
    }
}
