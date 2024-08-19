package com.coffee.RoastyToasty.Service.Impl;

import com.coffee.RoastyToasty.Dto.OrderDTO;
import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Entity.Order;
import com.coffee.RoastyToasty.Entity.Product;
import com.coffee.RoastyToasty.Exception.ResourceNotFoundException;
import com.coffee.RoastyToasty.Mapper.OrderMapper;
import com.coffee.RoastyToasty.Repository.CustomerRepository;
import com.coffee.RoastyToasty.Repository.OrderRepository;
import com.coffee.RoastyToasty.Repository.ProductRepository;
import com.coffee.RoastyToasty.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ProductRepository productRepository;

    CustomerRepository customerRepository;

    @Autowired
    OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;

    }

    // Create a new order
    public Order createOrder(Order order) {
        Optional<Customer> customer = customerRepository.findById(order.getCustomer().getCustomerId());
        if (customer.isPresent()) {
            order.setCustomer(customer.get());
            List<Product> products = order.getProducts().stream()
                    .map(product -> productRepository.findById(product.getProductId())
                            .orElseThrow(() -> new RuntimeException("Product not found")))
                    .collect(Collectors.toList());

            order.setProducts(products);
            order.setTotalPrice(calculateTotalPrice(products));
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    private Double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public List<OrderDTO> getAll() {
        List <Order> orders = orderRepository.findAll();

        return orders.stream().map((order)-> OrderMapper.mapToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new ResourceNotFoundException("Order with id " + orderId + " not found")
        );
        order.setCustomer(updatedOrder.getCustomer());
        order.setTotalPrice(updatedOrder.getTotalPrice());
        order.setProducts(updatedOrder.getProducts());
        order.setStatus(updatedOrder.getStatus());
        order.setCreatedAt(updatedOrder.getCreatedAt());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }


}
