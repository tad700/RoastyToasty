package com.coffee.RoastyToasty.Controller;

import com.coffee.RoastyToasty.Entity.Order;
import com.coffee.RoastyToasty.Exception.ResourceNotFoundException;
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long orderId,@RequestBody Order order){
    Order order1 = orderService.updateOrder(orderId,order);
    return ResponseEntity.ok(order1);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id){
    try {
        orderService.deleteOrder(id);
    }catch (ResourceNotFoundException e){
        e.getCause();
    }
    return ResponseEntity.ok("Order deleted successfully");

    }

}
