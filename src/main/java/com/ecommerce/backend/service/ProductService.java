package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setNombre(productDetails.getNombre());
                    product.setDescripcion(productDetails.getDescripcion());
                    product.setPrecio(productDetails.getPrecio());
                    product.setStock(productDetails.getStock());
                    product.setCategoria(productDetails.getCategoria());
                    product.setImagenUrl(productDetails.getImagenUrl());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    productDetails.setId(id);
                    return productRepository.save(productDetails);
                });
    }
}
