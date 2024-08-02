package com.coffee.RoastyToasty.Mapper;

import com.coffee.RoastyToasty.Dto.CustomerDTO;
import com.coffee.RoastyToasty.Entity.Customer;

public class CustomerMapper {
    public static CustomerDTO maptoCustomerDTO(Customer customer) {
        return new CustomerDTO(
            customer.getCustomerId(),
            customer.getName(),
            customer.getEmail(),
            customer.getPhoneNumber(),
            customer.getAddress(),
            customer.getCreatedAt()
        );
    }

    public static Customer maptoCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getEmail(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddress(),
                customerDTO.getCreatedAt()
        );
    }
}
