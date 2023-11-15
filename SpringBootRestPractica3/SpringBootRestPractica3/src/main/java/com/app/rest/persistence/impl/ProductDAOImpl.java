package com.app.rest.persistence.impl;

import com.app.rest.entities.Product;
import com.app.rest.persistence.IProductDAO;
import com.app.rest.repository.ProductRepository;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Component
public class ProductDAOImpl implements IProductDAO {
    private ProductRepository productRepository;

    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findProductByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
       productRepository.deleteById(id);
    }
}
