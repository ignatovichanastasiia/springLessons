package ru.geekbrains.thirdLesson.service;

import ru.geekbrains.thirdLesson.domein.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAll();

    public Optional<Product> findById(Long id);

    public boolean removeByID(Long id);

    public Product save(Product product);

    public List<Product> findByCostLessThanEqualAndCostGreaterThanEqual(int maxCost, int minCost);
}
