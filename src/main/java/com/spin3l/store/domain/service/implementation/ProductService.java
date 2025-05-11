package com.spin3l.store.domain.service.implementation;

import com.spin3l.store.domain.model.Product;
import com.spin3l.store.domain.repository.IProductRepository;
import com.spin3l.store.domain.service.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) throws
                                           EntityNotFoundException {
        return this.productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product updateProduct(
            Long id,
            Product updatedProduct
    ) throws
      EntityNotFoundException {
        Product product = this.getProductById(id);

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());

        return this.productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long id) throws
                                          EntityNotFoundException {
        Product product = this.getProductById(id);

        this.productRepository.delete(product);
        return product;
    }
}
