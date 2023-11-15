package com.app.rest.dto;

import com.app.rest.entities.Maker;
import com.app.rest.entities.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;
    @NotBlank
    private String name;
    private List<Product> products= new ArrayList<>();

    public MakerDTO(Maker maker) {
        this.id= maker.getId();
        this.name= maker.getName();
        this.products=maker.getProducts();
    }
}
