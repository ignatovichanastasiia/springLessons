package ru.geekbrains.thirdLesson.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.geekbrains.thirdLesson.domein.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCostLessThanEqualAndCostGreaterThanEqual(int maxCost, int minCost);

}