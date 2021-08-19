package ru.geekbrains.thirdLesson.service.Impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.Impl.ProductRepositoryImpl;
import ru.geekbrains.thirdLesson.repo.ProductRepository;
import ru.geekbrains.thirdLesson.test_class.SpringMvcDemoApplicationTest;

import java.util.HashMap;
import java.util.Map;

class ProductServiceImplTest extends SpringMvcDemoApplicationTest {

    @MockBean
    ProductServiceImpl productService;
    @MockBean
    ProductRepositoryImpl productRepository;

    Product product;
    Product product1;
    Product product2;

    @BeforeEach
    void unit() {
        Product product = new Product(1l, "title", 20000);
        Product product1 = new Product(2L, "title", 30000);
    }

    @MockBean
    Map<Long, Product> productMapTest;
    Map<Long, Product> productMap;

    @Test
    void newProductAdd() {
        productMapTest.put(1L, product);
        productService.newProductAdd(1l, "title", 20000);
        productMap = productService.getProducts();
        Assertions.assertEquals(productMap, productMapTest);
    }

    @Test
    void add() {
        productMapTest.put(2L, product1);
        productService.add(2L, product1);
        productMap = productService.getProducts();
        Assertions.assertEquals(productMapTest, productMap);
    }

    @Test
    void isId() {
        Assertions.assertTrue(productService.isId(1L));
    }

    @Test
    void findById() {
        product2 = productService.findById(1L).get();
        Assertions.assertEquals(product, product2);
    }

    @Test
    void getProducts() {
        Assertions.assertEquals(productMapTest, productService.getProducts());
    }

    @Test
    void removeByID() {
        productMapTest.remove(product);
        productService.removeByID(1L);
        Assertions.assertEquals(productMapTest, productService.getProducts());
    }
}