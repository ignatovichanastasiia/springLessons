package ru.geek;

import org.flywaydb.core.Flyway;
import ru.geek.domain.Product;
import ru.geek.repo.Impl.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/hbLessons-app", "postgres", "postgrespass").load();
        flyway.migrate();
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        repository.add(new Product("title01",23000));
        repository.newProductAdd("title02",33000);
        System.out.println(repository.getProducts());
        Product product = repository.findById(1L).get();
        System.out.println(product);
        if(product!=null)product.setCost(45000);
        repository.productUpdate(product);
        product = repository.findById(1L).get();
        System.out.println(product);
        repository.removeByID(1L);
        System.out.println(repository.getProduct());
    }
}

