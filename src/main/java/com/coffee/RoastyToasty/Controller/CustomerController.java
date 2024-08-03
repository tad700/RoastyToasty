package com.coffee.RoastyToasty.Controller;


import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    public CustomerService customerService;

    @PostMapping("add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.addCustomer(customer);

        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("get5ByName")
    public List<Customer> getTop5ByName() {
        return customerService.getTop5ByName();
    }

    //Build Update Employee REST API
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer) {
        Customer customer1 = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok(customer1);
    }

    //Build Delete Customer REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerID) {
        customerService.deleteCustomer(customerID);
        return ResponseEntity.ok("Customer deleted successfully!");
    }
}
