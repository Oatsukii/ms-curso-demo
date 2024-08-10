package com.lite.ms_curso_demo.application;

import com.lite.ms_curso_demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductApplication extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
    List<Product> findByPrice(float price);
    List<Product> findByNameContaining(String name);

}
