package com.apiTest.dao;

import com.apiTest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by beramos on 5/4/17.
 */
public interface ProductRepository extends JpaRepository<Product , Long> {
}
