package com.coffee.RoastyToasty.Service;

import com.coffee.RoastyToasty.Dto.CustomerDTO;
import com.coffee.RoastyToasty.Entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<CustomerDTO> getAll();

    List<Customer> getTop5ByName();

    Customer updateCustomer(Long customerId, Customer updatedCustomer);

    void deleteCustomer(Long cusomerId);
}
