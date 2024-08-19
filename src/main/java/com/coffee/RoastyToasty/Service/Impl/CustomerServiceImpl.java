package com.coffee.RoastyToasty.Service.Impl;


import com.coffee.RoastyToasty.Dto.CustomerDTO;
import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Exception.ResourceNotFoundException;
import com.coffee.RoastyToasty.Mapper.CustomerMapper;
import com.coffee.RoastyToasty.Repository.CustomerRepository;
import com.coffee.RoastyToasty.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer){
        Customer savedCustomer = new Customer(customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getCreatedAt());
        customerRepository.save(savedCustomer);
        return savedCustomer;

    }

    @Override
    public List<CustomerDTO> getAll (){
         List<Customer> customers = customerRepository.findAll();

         return customers.stream().map((customer) -> CustomerMapper.maptoCustomerDTO(customer)).collect(Collectors.toList());


    }
    @Override
    public  List<Customer> getTop5ByName(){
        return customerRepository.findTop5ByOrderByNameAsc();

    }

    @Override
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                ()->new ResourceNotFoundException("Customer is not found with id"+customerId)
        );
        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customer.setCreatedAt(updatedCustomer.getCreatedAt());

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(
                ()->new ResourceNotFoundException("Customer is not found with id"+customerId)
        );
        customerRepository.deleteById(customerId);
    }


}
