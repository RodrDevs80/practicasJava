package com.sertec.api_crud.service;

import com.sertec.api_crud.DTO.ProductDTO;
import com.sertec.api_crud.mapper.ProductDTOTOProduct;
import com.sertec.api_crud.persistence.entity.Product;
import com.sertec.api_crud.persistence.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.Any;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;
    private ProductDTOTOProduct productDTOTOProduct;
    public ProductService(ProductRepository repository, ProductDTOTOProduct productDTOTOProduct) {
        this.repository = repository;
        this.productDTOTOProduct = productDTOTOProduct;
    }

    public List<Product> productList(){
        List<Product> products = repository.findAll();
        return  products;
    }

    public Product createProduct(ProductDTO productDTO){
        Product product = productDTOTOProduct.map(productDTO);
        return  repository.save(product);
    }

    public boolean deleteById(Long id){
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    @Transactional
    public boolean updateProduct(ProductDTO productDTO,Long id){
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            if (!product.getName().equals(productDTO.getName())) {
                product.setName(productDTO.getName());
            }
            if (!product.getDescription().equals(productDTO.getDescription())) {
                product.setDescription(productDTO.getDescription());
            }
            if (product.getPrice() != productDTO.getPrice()) {
                product.setPrice(productDTO.getPrice());
            }
            if (product.getStock()!= productDTO.getStock()) {
                product.setStock(productDTO.getStock());
            }
            //cambia la fecha de creacion por la fecha de modificacion
            product.setCreationDate(LocalDateTime.now());

            return true;
        }
        return false;

    }
    @Transactional
    public ProductDTO findByName(String name){
        Optional<Product> productOptional = repository.findByName(name);
        if (productOptional.isPresent()){
            ProductDTO dto = ProductDTO.builder()
                    .name(productOptional.get().getName())
                    .description(productOptional.get().getDescription())
                    .price(productOptional.get().getPrice())
                    .stock(productOptional.get().getStock())
                    .creationDate(productOptional.get().getCreationDate())
                    .build();
            return dto;
        }

        return null;
    }
}
