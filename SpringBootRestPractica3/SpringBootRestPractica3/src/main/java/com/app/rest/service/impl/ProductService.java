package com.app.rest.service.impl;

import com.app.rest.entities.Product;
import com.app.rest.persistence.IProductDAO;
import com.app.rest.service.IProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService {
    private IProductDAO iProductDAO;

    public ProductService(IProductDAO iProductDAO) {
        this.iProductDAO = iProductDAO;
    }

    @Override
    public List<Product> findAll() {
        return iProductDAO.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductDAO.findById(id);
    }

    @Override
    public List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return iProductDAO.findProductByPriceBetween(minPrice, maxPrice);
    }


    @Override
    public void save(Product product) {
         iProductDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
         iProductDAO.deleteById(id);
    }
}
