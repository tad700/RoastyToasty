package com.coffee.RoastyToasty.api.repository;

import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Entity.Product;
import com.coffee.RoastyToasty.Repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void ProductRepository_AddProduct_ReturnSavedProduct(){
        Product product = Product.builder().name("Coffee").description("Black Coffee").type("Coffee").price(1.3).build();

        Product savedProduct = productRepository.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getProductId()).isGreaterThan(0);

    }
    @Test
    public void ProductRepository_GetByType_ReturnTypes(){
        Product product = Product.builder().name("Coffee").description("Black Coffee").type("Coffee").price(1.3).build();
        Product product2 = Product.builder().name("Latte").description("Latte Coffee").type("Coffee").price(2.0).build();

        productRepository.save(product);
        productRepository.save(product2);

        List<Product> products = productRepository.findByType("Coffee");



        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);


    }
    @Test
    public void ProductRepository_GetAll_ReturnMoreThanOneProduct(){
        Product product = Product.builder().name("Coffee").description("Black Coffee").type("Coffee").price(1.3).build();
        Product product2 = Product.builder().name("Latte").description("Latte Coffee").type("Coffee").price(2.0).build();

        productRepository.save(product);
        productRepository.save(product2);
        List<Product> products = productRepository.findAll();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);
    }

    @Test
    public void ProductRepository_FindById_ReturnProductWithId(){
        Product product = Product.builder().name("Coffee").description("Black Coffee").type("Coffee").price(1.3).build();
        productRepository.save(product);
        Product productReturn = productRepository.findById(product.getProductId()).get();

        Assertions.assertThat(productReturn).isNotNull();



    }


}
