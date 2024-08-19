package com.coffee.RoastyToasty.Repository;

import com.coffee.RoastyToasty.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
