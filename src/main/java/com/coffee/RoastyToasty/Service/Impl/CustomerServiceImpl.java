package com.coffee.RoastyToasty.Service.Impl;

import com.coffee.RoastyToasty.Dto.CustomerDTO;
import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Mapper.CustomerMapper;
import com.coffee.RoastyToasty.Repository.CustomerRepository;
import com.coffee.RoastyToasty.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


}
