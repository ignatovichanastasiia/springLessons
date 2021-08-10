package repo.impl;

import domain.Product;
import org.springframework.stereotype.Repository;
import repo.RepositoryService;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements RepositoryService {

    private Map<Long,Product> productMap;

    @PostConstruct
    private void init(){
        Random rn = new Random();
        productMap = new HashMap<>();
        for(int i=1;i<6;i++){
            productMap.put((long)(1000+i),new Product((long)(1000+i),("title"+String.valueOf(i)),(rn.nextInt(10)*1000)));
        }
    }

    @Override
    public Map<Long, Product> getProducts() {
        return productMap;
    }

    @Override
    public Product findById(long id) {
        return productMap.get(id);
    }

//TO DO after reading about Optional;
    @Override
    public boolean isId(long id) {
        if(productMap.containsKey(id)) return true;
        return false;
    }
}

