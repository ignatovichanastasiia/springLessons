package ru.geekbrains.thirdLesson.repo.Impl;


import org.springframework.stereotype.Repository;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private Map<Long, Product> productMap;

    @PostConstruct
    private void init(){
        Random rn = new Random();
        productMap = new HashMap<>();
        for(int i=1;i<6;i++){
            productMap.put((long)(1000+i),new Product((long)(1000+i),("title"+String.valueOf(i)),(rn.nextInt(10)*1000)));
        }
    }

    @Override
    public boolean newProductAdd(long id, String title, int cost) {
        if (!isId(id)) {
            productMap.put(id, (new Product(id, title, cost)));
            return true;
        }
        return false;
    }

    @Override
    public boolean add(long id, Product product) {
        if(!isId(id)){
            productMap.put(id,product);
            return true;
        }
        return false;
    }

    @Override
    public boolean isId(long id) {
        if(productMap.containsKey(id)) return true;
        return false;
    }

    @Override
    public Optional<Product> findById(long id) {
        if(isId(id)){
            return Optional.of(productMap.get(id));
        }
        return Optional.empty();
    }

    @Override
    public Map<Long, Product> getProducts() {
        return productMap;
    }


    @Override
    public boolean removeByID(long id) {
        if(isId(id)){
            productMap.remove(id);
            return true;
        }
        return false;
    }

}


