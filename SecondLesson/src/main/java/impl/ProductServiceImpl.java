package impl;

import domain.Product;
import repo.ProductRepository;
import service.ProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    public ProductServiceImpl(Qualifier("ProductRepositoryImpl") ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.getProducts();
    }
}
