package com.apiTest.Controllers;

import com.apiTest.dao.ProductRepository;
import com.apiTest.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by beramos on 5/4/17.
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;


    @Autowired
    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value ="/getAll" ,method = RequestMethod.GET)
    Collection<Product> getAllProducts() {

        return this.productRepository.findAll();
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST )
    public ResponseEntity add(@RequestBody Product input) {

//        System.out.println(" add product ");
       // System.out.println(input.getDescription() + " " + input.getPrice() + " " + input.getQte());

        productRepository.save(input);

         return new ResponseEntity(HttpStatus.CREATED);
    }



    @RequestMapping(method = RequestMethod.GET, value = "/get/{productId}")
    Product getSingleProduct(@PathVariable int productId) {

        return this.productRepository.findOne(new Long(productId));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{productId}")
    public void deleteProduct(@PathVariable int productId) {

        productRepository.delete(new Long(productId));

    }

}
