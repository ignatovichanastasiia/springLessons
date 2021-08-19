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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest extends SpringMvcDemoApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private Product product = new Product(1L,"title",23000);

//    Product product;
//    private HashMap<Long,Product> map;


//    @BeforeEach
//    void setUp(){
//        Product product = new Product(1L,"title",23000);
//        HashMap map = new HashMap();
//        map.put(product.getId(),product);
//        Mockito.when(productService.getProducts()).
//            thenReturn(map);
//    }

    @Test
    void getProducts() throws Exception {
        ArrayList<Product> list = new ArrayList();
        list.add(product);
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products",list));
    }

    @Test
    void getProductInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/product_info"))
                .andExpect(model().attribute("product", product));
    }
}