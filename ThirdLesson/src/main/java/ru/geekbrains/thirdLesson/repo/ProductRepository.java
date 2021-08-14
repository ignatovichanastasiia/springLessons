package ru.geekbrains.thirdLesson.repo;

import ru.geekbrains.thirdLesson.domein.Product;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {

    public boolean newProductAdd(long id, String title, int cost);

    public boolean add(long id, Product product);

    public boolean isId(long id);

    public Optional<Product> findById(long id);

    public Map<Long, Product> getProducts();

    public boolean removeByID(long id);

}