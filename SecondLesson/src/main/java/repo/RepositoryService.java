package repo;

import domain.Product;
import java.util.Map;

public interface RepositoryService {

    public Map<Long, Product> getProducts();

    public Product findById(long id);

    public boolean isId(long id);
}
