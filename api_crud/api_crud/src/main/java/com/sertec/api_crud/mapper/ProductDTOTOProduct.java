package com.sertec.api_crud.mapper;

import com.sertec.api_crud.DTO.ProductDTO;
import com.sertec.api_crud.persistence.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class ProductDTOTOProduct implements IMapper<ProductDTO, Product>{


    @Override
    public Product map(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .stock(productDTO.getStock())
                .creationDate(LocalDateTime.now())
                .build();
        return product;
    }
}
