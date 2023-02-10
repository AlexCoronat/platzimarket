package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController /*Le indica a la clase que se comportara como una controladora de la API*/
@RequestMapping("/products")
public class ProductController {
    @Autowired /*Es posible utilizar esta anotacion porque ProductService tiene una anotacion de Spring*/
    private ProductService productService;
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productService.save(product);
    }
    public boolean delete(int productId){
        return productService.delete(productId);
    }
}
