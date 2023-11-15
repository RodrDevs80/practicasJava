package com.sertec.api_crud.DTO;

import com.sertec.api_crud.persistence.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String name;
    private String description;
    private float price;
    private int stock;
    private LocalDateTime creationDate;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description= product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.creationDate = LocalDateTime.now();
    }
}
