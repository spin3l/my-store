package com.spin3l.store.domain.service;

import com.spin3l.store.domain.model.Product;

import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(
            Long id,
            Product updatedProduct
    );

    Product deleteProduct(Long id);
}
