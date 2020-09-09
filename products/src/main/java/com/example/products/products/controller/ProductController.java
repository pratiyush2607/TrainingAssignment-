package com.example.products.products.controller;

import com.example.products.products.model.Product;
import com.example.products.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    ProductRepository repository;
    @RequestMapping(value="/product", method= RequestMethod.GET)
    public List<Product> getProducts(){

        return repository.findAll();
    }
    @RequestMapping(value="/product/{id}", method= RequestMethod.GET)
    public Product getProduct(@PathVariable("id") String id){
        return repository.findById(id).get();
    }
    @RequestMapping(value="/product", method= RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }
}
