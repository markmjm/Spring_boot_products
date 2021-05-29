package com.mjm.springcloud.repos;

import com.mjm.springcloud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
