package ru.geekbrains.thirdLesson.service;

import ru.geekbrains.thirdLesson.domein.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    public boolean newProductAdd(Long id, String title, int cost);

    public boolean add(Long id, Product product);

    public boolean isId(Long id);

    public Optional<Product> findById(Long id);

    public HashMap<Long, Product> getProducts();

    public boolean removeByID(Long id);

}
