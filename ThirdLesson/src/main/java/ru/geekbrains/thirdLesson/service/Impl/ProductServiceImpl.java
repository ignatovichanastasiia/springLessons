package ru.geekbrains.thirdLesson.service.Impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.thirdLesson.domein.Category;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.Impl.ProductRepositoryImpl;
import ru.geekbrains.thirdLesson.service.ProductService;

import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl productRepository;

//    @Override
//    public boolean newProductAdd(String title, int cost, Long category) {
//        return productRepository.newProductAdd(title, cost, category);
//    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

//    @Override
//    public boolean isId(Long id) {
//        return productRepository.isId(id);
//    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    @Override
    public HashMap<Long,Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public HashMap getProductsByCategory(Long categoryID){
        return productRepository.getProductsByCategory(categoryID);
    }

    @Override
    public boolean removeByID(Long id) {
        return productRepository.removeByID(id);
    }

    @Override
    public boolean productUpdate(Product newVersionProduct){
        return productRepository.productUpdate(newVersionProduct);
    }
}

