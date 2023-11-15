package com.app.rest.repository;

import com.app.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    //Query Methods
    List<Product> findProductByPriceBetween(BigDecimal minPrice,BigDecimal maxPrice);
}
