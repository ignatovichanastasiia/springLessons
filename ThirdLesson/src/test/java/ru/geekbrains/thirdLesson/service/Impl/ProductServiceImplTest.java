package ru.geekbrains.thirdLesson.service.Impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.Impl.ProductRepositoryImpl;
import ru.geekbrains.thirdLesson.SpringMvcDemoApplicationTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class ProductServiceImplTest extends SpringMvcDemoApplicationTest {

    @Autowired
    ProductServiceImpl productService;
    @MockBean
    ProductRepositoryImpl productRepository;


    @Test
    void newProductAdd() {
        HashMap<Long, Product> productMapTest = new HashMap<>();
        HashMap<Long, Product> productMap = new HashMap<>();
        Product product = new Product(1L, "title", 20000);
        productMapTest.put(1L, product);
        productService.newProductAdd(1l, "title", 20000);
        Mockito.when(productRepository.getProducts()).thenReturn(productMapTest);
        productMap = productService.getProducts();
        Assertions.assertEquals(productMapTest, productMap);
    }

    @Test
    void add() {
        HashMap<Long, Product> productMapTest = new HashMap<>();
        HashMap<Long, Product> productMap = new HashMap<>();
        Product product1 = new Product(2L, "title", 30000);
        productMapTest.put(2L, product1);
        productService.add(2L, product1);
        Mockito.when(productRepository.getProducts()).thenReturn(productMapTest);
        productMap = productService.getProducts();
        Assertions.assertEquals(productMapTest, productMap);
    }

    @Test
    void isId() {
        Mockito.when(productRepository.isId(1L)).thenReturn(true);
        Assertions.assertTrue(productService.isId(1L));
    }

    @Test
    void findById() {
        Product product = new Product(1L, "title", 20000);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product product2 = productService.findById(1L).get();
        Assertions.assertEquals(product, product2);
    }

    @Test
    void getProducts() {
        HashMap<Long, Product> productMapTest = new HashMap<>();
        Product product = new Product(1L, "title", 20000);
        productMapTest.put(1L, product);
        Mockito.when(productRepository.getProducts()).thenReturn(productMapTest);
        Assertions.assertEquals(productMapTest, productService.getProducts());
    }

    @Test
    void removeByID() {
        HashMap<Long, Product> productMapTest = new HashMap<>();
        Mockito.when(productRepository.removeByID(1L)).thenReturn(true);
        Assertions.assertTrue(productService.removeByID(1L));
    }
}