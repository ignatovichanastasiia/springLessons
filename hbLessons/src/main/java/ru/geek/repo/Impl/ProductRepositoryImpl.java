package ru.geek.repo.Impl;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geek.domain.Product;
import ru.geek.repo.ProductRepository;

import java.util.*;

@Data
public class ProductRepositoryImpl implements ProductRepository {

    public static SessionFactory factory;

    Product product;
    HashMap map;

    private static void init() {
        factory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
    }

    private void shutDown() {
        factory.close();
    }

    @Override
    public boolean newProductAdd(String title, int cost) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = new Product(title, cost);
            //TO DO if(isId)
            session.save(product);
            session.getTransaction().commit();
        } finally {
            System.out.println(product);
        }
        return true;
    }

    @Override
    public boolean add(Product product) {
        //TO DO if(isID)
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } finally {
            System.out.println(product);
        }
        return true;
    }

//    @Override
//    public boolean isId(Long id) {
//        if(productMap.containsKey(id)) return true;
//        return false;
//    }

    @Override
    public Optional<Product> findById(Long id) {
        //TO DO if(isId)
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        } finally {
            System.out.println(product);
        }
        return Optional.of(product);
    }

    @Override
    public HashMap<Long, Product> getProducts() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            ArrayList<Product> list = new ArrayList(session.createQuery("select p from Product p ").getResultList());
            session.getTransaction().commit();
            list.stream().forEach(x -> map.put(x.getId(), x));
        } finally {
            System.out.println(map);
        }
        return map;
    }


    @Override
    public boolean removeByID(Long id) {
        //TO DO if(isId)
        boolean isDeleted = false;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
                isDeleted = true;
            }
            session.getTransaction().commit();
        }
        return isDeleted;
    }

    public boolean productUpdate(Product newVersionProduct){
        //TO DO if(isId)
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, newVersionProduct.getId());
            if(!product.getTitle().equals(newVersionProduct.getTitle())){
                product.setTitle(newVersionProduct.getTitle());
            }
            if(product.getCost() != newVersionProduct.getCost()){
                product.setCost(newVersionProduct.getCost());
            }
            session.getTransaction().commit();
        } finally {
            System.out.println(product);
        }
        return true;
    }
}
