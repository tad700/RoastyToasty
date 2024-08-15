package com.coffee.RoastyToasty.Service;

import com.coffee.RoastyToasty.Entity.Order;

import java.util.List;

public interface OrderService {
     Order createOrder(Order order);

     List<Order> getAll();

     Order updateOrder(Long orderId,Order updatedOrder);

     void deleteOrder(Long id);
}
