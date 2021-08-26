//package ru.geekbrains.thirdLesson.repo.Impl;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.event.annotation.BeforeTestClass;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.geekbrains.thirdLesson.SpringMvcDemoApplicationTest;
//import ru.geekbrains.thirdLesson.domein.Product;
//
//import java.util.HashMap;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ProductRepositoryImplTest extends SpringMvcDemoApplicationTest {
//
//    @Autowired
//    ProductRepositoryImpl repository;
//
//
//    @Test
//    void newProductAdd() {
//        HashMap<Long, Product> testMap = new HashMap<>();
//        repository.setProductMap(testMap);
//        Product product = new Product(1L,"t",23000);
//        testMap.put(1L, product);
//        repository.newProductAdd(1L,"t",23000);
//        Assertions.assertEquals(testMap,repository.getProducts());
//    }
//
//    @Test
//    void add() {
//        HashMap<Long, Product> testMap = new HashMap<>();
//        repository.setProductMap(testMap);
//        Product product = new Product(1L,"t",23000);
//        testMap.put(1L, product);
//        repository.add(1L, product);
//        Assertions.assertEquals(testMap,repository.getProducts());
//    }
//
//    @Test
//    void isId() {
//        HashMap<Long, Product> testMap = new HashMap<>();
//        Product product = new Product(1L,"t",23000);
//        testMap.put(1L,product);
//        repository.setProductMap(testMap);
//        Assertions.assertTrue(repository.isId(1L));
//    }
//
//    @Test
//    void findById() {
//        HashMap<Long, Product> testMap = new HashMap<>();
//        Product product = new Product(1L,"t",23000);
//        testMap.put(1L,product);
//        repository.setProductMap(testMap);
//        Product product1 = repository.findById(1L).get();
//        Assertions.assertEquals(product, product1);
//    }
//
//    @Test
//    void getProducts() {
//        HashMap<Long, Product> testMap = new HashMap<>();
//        Product product = new Product(1L,"t",23000);
//        testMap.put(1L,product);
//        Assertions.assertEquals(testMap, repository.getProducts());
//    }
//
//    @Test
//    void removeByID() {
//        HashMap<Long, Product> testMap = new HashMap<>();
//        Product product = new Product(1L,"t",23000);
//        testMap.put(1L,product);
//        repository.setProductMap(testMap);
//        repository.removeByID(1L);
//        Assertions.assertTrue(repository.getProducts().isEmpty());
//    }
//}