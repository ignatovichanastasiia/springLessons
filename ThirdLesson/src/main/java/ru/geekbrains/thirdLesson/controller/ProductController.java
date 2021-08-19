package ru.geekbrains.thirdLesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.Map;


@Controller
@AllArgsConstructor
//@RequestMapping("/")
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    @ResponseBody
    public String getProducts(Model model) {
        Map getProducts = productService.getProducts();
        model.addAttribute("products", getProducts);
        return "products";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public String getProductInfo(Model model, @PathVariable long id) {
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

    @GetMapping("exception")
    public String getExceptionPage(Model model) {
//        model.addAttribute("someTestProd", new Product(1l,"Title",20000));
        return "exception";
    }

    @PostMapping("/products/add_product")
    public String addProduct(@ModelAttribute Product product, Model model) {
        if (productService.add(product.getId(), product)) {
            return "redirect:/products";
        }
        return "redirect:/exception";
    }

//    @GetMapping("/test")
//    public String test(){
//        return "test";
//    }
}
