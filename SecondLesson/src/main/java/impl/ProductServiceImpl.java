package impl;

import domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repo.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl productRepository;

    public ProductServiceImpl(@Qualifier("ProductRepositoryImpl") ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Map<Long, Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean isId(long id) {
        return productRepository.isId(id);
    }
}
