package com.data.demo_springboot_student.repo;

import com.data.demo_springboot_student.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Product product);
}