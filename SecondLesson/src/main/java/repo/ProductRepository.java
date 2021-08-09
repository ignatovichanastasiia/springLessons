package repo;

import domain.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> getProducts() {
        return new ArrayList<Product>();
    }

}

}
