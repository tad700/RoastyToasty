package com.coffee.RoastyToasty.Controller;

import com.coffee.RoastyToasty.Dto.CustomerDTO;
import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    public CustomerService customerService;

    @PostMapping("addCustomer")
    public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO customerDTO) {
        return null;
    }
}
