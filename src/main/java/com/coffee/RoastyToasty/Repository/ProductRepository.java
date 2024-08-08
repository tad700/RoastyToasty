package com.coffee.RoastyToasty.Repository;

import com.coffee.RoastyToasty.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {

}
