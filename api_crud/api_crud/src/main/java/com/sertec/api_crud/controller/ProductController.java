package com.sertec.api_crud.controller;

import com.sertec.api_crud.DTO.ProductDTO;
import com.sertec.api_crud.persistence.entity.Product;
import com.sertec.api_crud.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ApiProducts")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity<?> listProducts(){
        List<Product> products = productService.productList();
        //Page<ProductDTO>  productDTOPage = new PageImpl<>(products.stream().map(ProductDTO::new).toList());
        if (products.isEmpty()){
            return  ResponseEntity.unprocessableEntity().body("The product list is empty");
        }
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.ok(productDTOS);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        Product product = productService.createProduct(productDTO);
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(url).body(productDTO);
    }

    @DeleteMapping("/deleteByIdProduct/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        boolean deleted = productService.deleteById(id);
        if (deleted){
            return ResponseEntity.ok("The product was deleted successfully");
        }
        return  ResponseEntity.badRequest().body("The product ID you want to delete does not exist!!!");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?>  updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        boolean updatedProduct = productService.updateProduct(productDTO, id);
        if (updatedProduct){
            return ResponseEntity.ok("The product was modified successfully.");
        }
        return  ResponseEntity.badRequest().body("The product ID you want to modify does not exist!!!");

    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        ProductDTO productDTO = productService.findByName(name);

        if(productDTO==null){
            return  ResponseEntity.badRequest().body("The product does not exist!!!");
        }

       return ResponseEntity.ok(productDTO);
    }

}
