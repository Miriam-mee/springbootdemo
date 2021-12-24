package com.services.demoproject.springbootdemo.Repository;

import com.services.demoproject.springbootdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
