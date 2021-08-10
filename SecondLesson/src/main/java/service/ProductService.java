package service;

import domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public Map<Long, Product> getProducts();

    public Product findById(long Id);

    public boolean isId(long Id);
}
