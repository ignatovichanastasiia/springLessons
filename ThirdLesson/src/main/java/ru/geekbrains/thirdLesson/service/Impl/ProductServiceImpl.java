package ru.geekbrains.thirdLesson.service.Impl;


import org.springframework.stereotype.Service;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.Impl.ProductRepositoryImpl;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl productRepository;

    public ProductServiceImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean newProductAdd(long id, String title, int cost) {
        return productRepository.newProductAdd(id, title, cost);
    }

    @Override
    public boolean add(long id, Product product) {
        return productRepository.add(id, product);
    }

    @Override
    public boolean isId(long id) {
        return productRepository.isId(id);
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }


    @Override
    public Map<Long, Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public boolean removeByID(long id) {
        return productRepository.removeByID(id);
    }
}

