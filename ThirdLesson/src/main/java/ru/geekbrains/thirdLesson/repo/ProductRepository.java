package ru.geekbrains.thirdLesson.repo;

import ru.geekbrains.thirdLesson.domein.Category;
import ru.geekbrains.thirdLesson.domein.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {

//    public boolean newProductAdd(String title, int cost, Long category);

    public boolean add(Product product);

//    public boolean isId(Long id);

    public Optional<Product> findById(Long id);

    public HashMap<Long, Product> getProducts();

    public HashMap<Long,Product> getProductsByCategory(Long categoryID);

    public boolean removeByID(Long id);

    public boolean productUpdate(Product newVersionProduct);

}