package ru.geekbrains.thirdLesson.repo.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.thirdLesson.component.HibernateSessionFacManager;
import ru.geekbrains.thirdLesson.domein.Category;
import ru.geekbrains.thirdLesson.domein.Product;
import ru.geekbrains.thirdLesson.repo.ProductRepository;


import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class ProductRepositoryImpl implements ProductRepository {

    HibernateSessionFacManager sessionManager;

    Product product;
    HashMap map;


//    @Override
//    public boolean newProductAdd(String title, int cost, Long category) {
//        try (Session session = sessionManager.getSession()) {
//            session.beginTransaction();
//            product = new Product(title, cost);
//            //TO DO if(isId)
//            session.save(product);
//            session.getTransaction().commit();
//        } finally {
//            System.out.println(product);
//        }
//        return true;
//    }

    @Override
    public boolean add(Product product) {
        //TO DO if(isID)
        try (Session session = sessionManager.getSession()) {
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
        try (Session session = sessionManager.getSession()) {
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
        try (Session session = sessionManager.getSession()) {
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
    public HashMap getProductsByCategory(Long categoryID) {
        try (Session session = sessionManager.getSession()) {
            session.beginTransaction();
            ArrayList<Product> list = new ArrayList(session.createQuery("select p from Product p ").getResultList());
            session.getTransaction().commit();
            ArrayList<Product> categoryProd = new ArrayList<>();
            list.stream().filter(x -> x.getCategory().equals(getCategoryById(categoryID))).forEach(x -> map.put(x.getId(), x));
        } finally {
            System.out.println(map);
        }
        return map;
    }


    @Override
    public boolean removeByID(Long id) {
        //TO DO if(isId)
        boolean isDeleted = false;
        try (Session session = sessionManager.getSession()) {
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

    @Override
    public boolean productUpdate(Product newVersionProduct) {
        //TO DO if(isId)
        try (Session session = sessionManager.getSession()) {
            session.beginTransaction();
            product = session.get(Product.class, newVersionProduct.getId());
            if (!product.getTitle().equals(newVersionProduct.getTitle())) {
                product.setTitle(newVersionProduct.getTitle());
            }
            if (product.getCost() != newVersionProduct.getCost()) {
                product.setCost(newVersionProduct.getCost());
            }
            session.getTransaction().commit();
        } finally {
            System.out.println(product);
        }
        return true;
    }

    public Optional<Category> getCategoryById(Long id) {
        Category category;
        try (Session session = sessionManager.getSession()) {
            session.beginTransaction();
            ArrayList<Category> list = new ArrayList(session.createQuery("select c from Category c ").getResultList());
            session.getTransaction().commit();
            category = list.stream().filter(x -> x.getId() == id).findFirst().get();
        }
        return Optional.ofNullable(category);
    }

}


