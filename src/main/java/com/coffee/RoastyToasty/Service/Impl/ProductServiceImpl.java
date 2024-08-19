package com.coffee.RoastyToasty.Service.Impl;

import com.coffee.RoastyToasty.Dto.ProductDTO;
import com.coffee.RoastyToasty.Entity.Product;
import com.coffee.RoastyToasty.Exception.ResourceNotFoundException;
import com.coffee.RoastyToasty.Mapper.ProductMapper;
import com.coffee.RoastyToasty.Repository.ProductRepository;
import com.coffee.RoastyToasty.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        Product savedProduct = new Product(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCreatedAt()
        );


        productRepository.save(savedProduct);
        return savedProduct;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map((product) -> ProductMapper.mapProductToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not found with ID" + id));
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setCreatedAt(updatedProduct.getCreatedAt());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product is not found with id" + productId));
        productRepository.deleteById(productId);

    }
}
