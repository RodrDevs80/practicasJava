package com.sertec.JSB.entityR.repository;

import com.sertec.JSB.entityR.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}
