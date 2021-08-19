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

    @MockBean
    Map<Long, Product> productMapTest;
    Map<Long, Product> productMap;



    @BeforeEach
    void setUp() {

        Product product = new Product(1l,"title",20000);
        Product product1 = new Product(2L,"title", 30000);
    }

    @Test
    void newProductAdd() {
        productMapTest.put(product.getId(),product);
        productService.newProductAdd(product.getId(), product.getTitle(),product.getCost());
        productMap = productService.getProducts();
        Assertions.assertEquals(productMap,productMapTest);
    }

    @Test
    void add() {
        productMapTest.put(product1.getId(),product1);
        productService.add(product1.getId(), product1);
        productMap = productService.getProducts();
        Assertions.assertEquals(productMapTest,productMap);
    }

    @Test
    void isId() {
        Assertions.assertTrue(productService.isId(product.getId()));
    }

    @Test
    void findById() {
        product2 = productService.findById(product.getId()).get();
        Assertions.assertEquals(product,product2);
    }

    @Test
    void getProducts() {
        Assertions.assertEquals(productMapTest,productService.getProducts());
    }

    @Test
    void removeByID() {
        productMapTest.remove(product);
        productService.removeByID(product.getId());
        Assertions.assertEquals(productMapTest, productService.getProducts());
    }
}