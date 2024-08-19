package com.coffee.RoastyToasty.Mapper;

import com.coffee.RoastyToasty.Dto.ProductDTO;
import com.coffee.RoastyToasty.Entity.Product;


public class ProductMapper {

    public static ProductDTO mapProductToDTO (Product product){
        return  new ProductDTO(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCreatedAt()
        );
    }
    public static Product mapToProduct(ProductDTO productDTO){
        return new Product(
                productDTO.getProductId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getCreatedAt()
        );

    }

}
