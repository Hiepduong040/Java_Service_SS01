package com.data.demo_springboot_student.repo;

import com.data.demo_springboot_student.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public boolean save(Product product) {
        if (product == null){
            return false;
        }
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        if (product == null) {
            return false;
        }
        try {
            entityManager.merge(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        if (product == null) {
            return false;
        }
        Product p = entityManager.find(Product.class, product.getId());
        if (p != null) {
            entityManager.remove(p);
            return true;
        }else {
            return false;
        }
    }
}