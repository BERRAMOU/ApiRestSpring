package com.apiTest;

import com.apiTest.dao.ProductRepository;
import com.apiTest.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApiApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext = SpringApplication.run(TestApiApplication.class, args);

		ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

		productRepository.save(new Product("produit A " ,  18.00 , 12));
		productRepository.save(new Product("produit B " ,  19.00 , 10));
		productRepository.save(new Product("produit C " ,  28.00 , 11));


		productRepository.findAll().forEach(product -> System.out.println(product.getDescription()));
		System.out.println(productRepository.findOne(new Long(1)));
	}
}
