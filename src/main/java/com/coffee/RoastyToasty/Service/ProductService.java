package com.coffee.RoastyToasty.Service;

import com.coffee.RoastyToasty.Dto.ProductDTO;
import com.coffee.RoastyToasty.Entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<ProductDTO> getAll();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
