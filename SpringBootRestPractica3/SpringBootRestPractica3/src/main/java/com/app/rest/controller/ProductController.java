package com.app.rest.controller;

import com.app.rest.dto.ProductDTO;
import com.app.rest.entities.Maker;
import com.app.rest.entities.Product;
import com.app.rest.service.impl.MakerService;
import com.app.rest.service.impl.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;
    private MakerService makerService;
    public ProductController(ProductService productService, MakerService makerService) {
        this.productService = productService;
        this.makerService = makerService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()){
            return ResponseEntity.badRequest().body("The product does not exist");
        }
        Product product=optionalProduct.get();

        ProductDTO productDTO= ProductDTO
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .maker(product.getMaker())
                .build();
        //otra forma
       /* ProductDTO productDTO1=
                (new ProductDTO(product.getId(), product.getName(),product.getPrice(),product.getMaker() ));*/

        return ResponseEntity.ok(productDTO);
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> listProduct(){
        List<Product> productList = productService.findAll();
        List<ProductDTO> productDTOList=productList
                .stream()
                .map(ProductDTO::new).toList();
        //esta es otra forma
        /*List<ProductDTO> productList1=productService.findAll().stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker()).build()).toList();*/
        return ResponseEntity.ok(productDTOList);

    }
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {
       if(productDTO.getMaker().getId()==null ||productDTO.getMaker().getName()==""){
           return ResponseEntity.badRequest().body("The manufacturer id is null or empty");
       }

        Optional<Maker> optionalMaker = makerService.findById(productDTO.getMaker().getId());

        if (optionalMaker.isPresent()){
            Product product=Product.builder()
                    .id(productDTO.getId())
                    .name(productDTO.getName())
                    .price(productDTO.getPrice())
                    .maker(productDTO.getMaker())
                    .build();
            productService.save(product);
            return ResponseEntity.created(new URI("/api/product/create")).build();
        }
        if (productDTO.getMaker().getName()==null || productDTO.getMaker().getName()==""){
            return ResponseEntity.badRequest().body("The manufacturer name is null or empty");
        }
        Maker newMaker= Maker.builder()
                .name(productDTO.getMaker().getName())
                .build();
        makerService.save(newMaker);
        Product product=Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(newMaker)
                .build();
        productService.save(product);

        return ResponseEntity.created(new URI("/api/product/create")).build();

    }
    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<?> updateProduct(@PathVariable @Valid Long id,@RequestBody ProductDTO productDTO){

        if (productDTO.getName().isBlank() || productDTO.getPrice()==null || productDTO.getMaker()==null){
            return ResponseEntity.badRequest().body("The name or the price are null");
        }
            Optional<Product> optionalProduct = productService.findById(id);
            if(!optionalProduct.isPresent()){
                return ResponseEntity.badRequest().body("The product you want to modify does not exist");
            }

        if (productDTO.getMaker().getId()==null){
            return ResponseEntity.badRequest().body("The product you want to modify does not exist");
        }
        Optional<Maker> optionalMaker = makerService.findById(productDTO.getMaker().getId());
        Product uDproduct=optionalProduct.get();
        if(optionalMaker.isPresent()){
            uDproduct.setName(productDTO.getName());
            uDproduct.setPrice(productDTO.getPrice());
            uDproduct.setMaker(productDTO.getMaker());
        }
        if (productDTO.getMaker().getName()==null || productDTO.getMaker().getName()==""){
            return ResponseEntity.badRequest().body("Manufacturer name is null");
        }
        Maker newMaker = Maker.builder()
                .name(productDTO.getMaker().getName())
                .products(productDTO.getMaker().getProducts())
                .build();
        makerService.save(newMaker);
        uDproduct.setName(productDTO.getName());
        uDproduct.setPrice(productDTO.getPrice());
        uDproduct.setMaker(newMaker);
        productService.save(uDproduct);
        return ResponseEntity.ok("updated product");
    }
    @GetMapping("/findByPriceRange/{minPrice}/{maxPrice}")
    public ResponseEntity<?> findByPriceRange
            (@PathVariable BigDecimal minPrice,@PathVariable BigDecimal maxPrice){

        List<Product> productList = productService.findProductByPriceBetween(minPrice, maxPrice);

        return ResponseEntity.ok(productList);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()){
            productService.deleteById(id);
            return ResponseEntity.ok("Product Deleted Correctly");
        }
        return ResponseEntity.badRequest().body("The Product you are trying to delete does not exist");
    }

}
