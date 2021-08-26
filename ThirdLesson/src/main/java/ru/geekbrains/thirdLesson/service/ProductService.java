package ru.geekbrains.thirdLesson.service;

import ru.geekbrains.thirdLesson.domein.Product;

import java.util.HashMap;
import java.util.Optional;

public interface ProductRepository {

    public boolean newProductAdd(String title, int cost);

    public boolean add(Product product);

//    public boolean isId(Long id);

    public Optional<Product> findById(Long id);

    public HashMap<Long, Product> getProducts();

    public boolean removeByID(Long id);

}
