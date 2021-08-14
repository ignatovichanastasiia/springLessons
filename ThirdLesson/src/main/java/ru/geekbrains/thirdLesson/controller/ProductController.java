package ru.geekbrains.thirdLesson.controller;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collector;

@Controller
@AllArgsConstructor
public class ProductController {

// не работает и в конструкторе, и в поле
// @Value ("${server.port}")
// private int port;

    private ProductService productService;

    @GetMapping("/products")
//    @ResponseBody
    public String getProducts(Model model) {
//        ArrayList list = new ArrayList();
//        Map getProducts = productService.getProducts();
//        getProducts.values().stream().forEach(x -> {list.add(x);});
//        model.addAttribute("products", list);
        return "products";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public String getProductInfo(Model model, @PathVariable long id) {
        if (productService.isId(id)) {
            Product product = productService.findById(id).get();
            if (product != null) {
                model.addAttribute("product", product);
                return "product_info";
            }
        }
        return "redirect:/exception";
    }

    @GetMapping("/products/form")
    @ResponseBody
    public String getProductInfo(Model model) {
        return "form_add";
    }

    @GetMapping("/exception}")
    @ResponseBody
    public String getExceptionPage(Model model) {
//        model.addAttribute("someTestProd", new Product(1l,"Title",20000));
        return "exception";
    }

    @PostMapping("/products/add_product")
    @ResponseBody
    public String addProduct(@ModelAttribute Product product, Model model) {
        if (productService.add(product.getId(),product)) {
            return "redirect:/products";
        }
        return "redirect:/exception";
    }



}
