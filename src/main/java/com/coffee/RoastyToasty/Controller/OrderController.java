package com.coffee.RoastyToasty.Controller;

import com.coffee.RoastyToasty.Entity.Order;
import com.coffee.RoastyToasty.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")

public class OrderController {
    private final OrderService orderService;
@Autowired
    OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order createdOrder = orderService.createOrder(order);
            return ResponseEntity.ok(createdOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("getAll")
    public List<Order> getAll(){
       return orderService.getAll();
    }



}
