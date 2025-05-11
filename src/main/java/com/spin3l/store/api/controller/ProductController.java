package com.spin3l.store.api.controller;

import com.spin3l.store.domain.model.Product;
import com.spin3l.store.domain.model.dto.ProductCreateDto;
import com.spin3l.store.domain.model.dto.ProductDto;
import com.spin3l.store.domain.model.dto.ProductUpdateDto;
import com.spin3l.store.domain.model.mapper.IProductMapper;
import com.spin3l.store.domain.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService IProductService) {
        this.productService = IProductService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateDto productCreateDTO) {
        Product product      = IProductMapper.INSTANCE.productCreateDtoToProduct(productCreateDTO);
        Product savedProduct = this.productService.saveProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(IProductMapper.INSTANCE.productToProductDto(savedProduct));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id) {
        Product product = this.productService.getProductById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(IProductMapper.INSTANCE.productToProductDto(product));
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = this.productService.getAllProducts();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products
                              .stream()
                              .map(IProductMapper.INSTANCE::productToProductDto)
                              .toList());
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductUpdateDto productUpdateDto
    ) {
        Product product = IProductMapper.INSTANCE.productUpdateDtoToProduct(productUpdateDto);
        Product updatedProduct = this.productService.updateProduct(
                id,
                product
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(IProductMapper.INSTANCE.productToProductDto(updatedProduct));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long id) {
        Product product = this.productService.deleteProduct(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(IProductMapper.INSTANCE.productToProductDto(product));
    }

    @PatchMapping("{id}")
    public ResponseEntity<ProductDto> updateQuantity(
            @PathVariable Long id,
            @RequestBody BigInteger newQuantity
    ) {
        Product product = this.productService.getProductById(id);
        product.setQuantity(newQuantity);

        Product updatedProduct = this.productService.saveProduct(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(IProductMapper.INSTANCE.productToProductDto(updatedProduct));
    }
}
