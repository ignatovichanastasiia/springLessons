package ru.geekbrains.thirdLesson.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.SpringMvcDemoApplicationTest;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest extends SpringMvcDemoApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    @Test
    void getProducts() throws Exception {
        Product product = new Product(1L,"tit", 34000);
        HashMap<Long, Product> testMap = new HashMap<>();
        testMap.put(1L, product);
        ArrayList<Product> list = new ArrayList();
        list.add(product);
        Mockito.when(productService.getProducts()).thenReturn(testMap);
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products",list));
    }

    @Test
    void getProductInfo() throws Exception {
        Product product = new Product(1L,"tit", 34000);
        Mockito.when(productService.findById(1L)).thenReturn(Optional.of(product));
        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product_info"))
                .andExpect(model().attribute("product", product));
    }
}