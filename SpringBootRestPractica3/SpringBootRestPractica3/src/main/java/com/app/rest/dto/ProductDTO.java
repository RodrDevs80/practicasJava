package com.app.rest.dto;

import com.app.rest.entities.Maker;
import com.app.rest.entities.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private Maker maker;

    public ProductDTO(Product product) {
        this.id= product.getId();
        this.name= product.getName();
        this.price=product.getPrice();
        this.maker=product.getMaker();
    }
}
