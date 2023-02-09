package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /*Es un servicio de nuestras reglas de negocio*/
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Product save(Product producto){
        return productRepository.save(producto);
    }
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
