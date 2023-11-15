package com.app.rest.persistence;

import com.app.rest.entities.Maker;
import com.app.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IMakerDAO {
    List<Maker> findAll();
    Optional<Maker> findById(Long id);

    void save(Maker maker);

    void deleteById(Long id);


}
