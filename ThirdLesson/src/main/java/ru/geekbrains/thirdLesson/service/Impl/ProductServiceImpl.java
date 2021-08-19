package ru.geekbrains.thirdLesson.service.Impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.Impl.ProductRepositoryImpl;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl productRepository;

    @Override
    public boolean newProductAdd(Long id, String title, int cost) {
        return productRepository.newProductAdd(id, title, cost);
    }

    @Override
    public boolean add(Long id, Product product) {
        return productRepository.add(id, product);
    }

    @Override
    public boolean isId(Long id) {
        return productRepository.isId(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    @Override
    public HashMap<Long,Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public boolean removeByID(Long id) {
        return productRepository.removeByID(id);
    }
}

