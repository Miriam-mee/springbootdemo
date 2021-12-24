package com.services.demoproject.springbootdemo.service;

import com.services.demoproject.springbootdemo.Repository.ProductRepository;
import com.services.demoproject.springbootdemo.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product deleted  !! " + id;
    }


   /* public  Product updateProduct(int id, Product product){
        Product existingProduct= repository.findById(id).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }*/

    public Product updateProduct(int id, Product product){
        Product existingProduct= repository.findById(id).orElse(null);
        if(existingProduct == null)
            throw new RuntimeException("product not found");
        existingProduct.setName(product.getName());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
    public Product patchProduct(int id, Product product){
        Product existingProduct = repository.findById(id).orElse(null);
        if(product.getName() != null)
        existingProduct.setName(product.getName());
        if(product.getQuantity() != 0);
        existingProduct.setQuantity(product.getQuantity());
        if(product.getPrice() != 0);
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
