package com.coffee.RoastyToasty.Repository;


import com.coffee.RoastyToasty.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

     List<Customer> findTop5ByOrderByNameAsc();
}
