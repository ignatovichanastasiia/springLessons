package ru.geekbrains.thirdLesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.Impl.ProductRepositoryImpl;
import ru.geekbrains.thirdLesson.repo.ProductRepository;

@SpringBootApplication
public class ThirdLessonApplication {

	public static void main(String[] args) {

		SpringApplication.run(ThirdLessonApplication.class, args);

//		Product product = new Product(1L,"title",20);
//		System.out.println(product);
//		ProductRepository prodRepo = new ProductRepositoryImpl();
//		prodRepo.add(product.getId(), product);
//		prodRepo.getProducts();
//		prodRepo.findById(1L);
	}

}
