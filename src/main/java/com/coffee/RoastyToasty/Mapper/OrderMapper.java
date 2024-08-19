package com.coffee.RoastyToasty.Mapper;

import com.coffee.RoastyToasty.Dto.OrderDTO;
import com.coffee.RoastyToasty.Entity.Order;


public class OrderMapper {

    public static OrderDTO mapToDTO(Order order){
        return new OrderDTO(
                order.getOrderId(),
                order.getCustomer(),
                order.getTotalPrice(),
                order.getProducts(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }
    public static Order mapToOrder(OrderDTO orderDTO){
        return new Order(
                orderDTO.getOrderId(),
                orderDTO.getCustomer(),
                orderDTO.getTotalPrice(),
                orderDTO.getProducts(),
                orderDTO.getStatus(),
                orderDTO.getCreatedAt()
        );

    }

}
