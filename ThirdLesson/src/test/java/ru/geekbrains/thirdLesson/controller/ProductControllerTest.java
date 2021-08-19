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
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest extends SpringMvcDemoApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private HashMap<Long,Product> map;
    private Product product;

    @BeforeEach
    void setUp(){
        product = new Product(1L,"title",23000);
        map = new HashMap<>();
        map.put(product.getId(),product);
        Mockito.when(productService.getProducts()).
            thenReturn(map);
    }

    @Test
    void getProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products",map));
    }

    @Test
    void getProductInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/1L"))
                .andExpect(status().isOk())
                .andExpect(view().name("/product_info"))
                .andExpect(model().attribute("product", product));
    }
}