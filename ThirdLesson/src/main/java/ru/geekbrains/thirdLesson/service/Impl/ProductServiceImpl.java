package ru.geekbrains.thirdLesson.service.Impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.ProductRepository;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean removeByID(Long id) {
        return productRepository.findAll().remove(findById(id).get());
    }

    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }

//    public HashMap getProductsByCategory(Long categoryID){
//        return productRepository.getProductsByCategory(categoryID);
//    }
}

