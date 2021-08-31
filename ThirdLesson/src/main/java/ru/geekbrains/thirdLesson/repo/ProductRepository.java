package ru.geekbrains.thirdLesson.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.geekbrains.thirdLesson.domein.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}