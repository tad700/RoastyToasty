package com.coffee.RoastyToasty.api.repository;

import com.coffee.RoastyToasty.Entity.Customer;
import org.assertj.core.api.Assertions;
import com.coffee.RoastyToasty.Repository.CustomerRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void CustomerRepository_AddCustomer_ReturnSavedCustomer(){
        //Arrange
        Customer customer = Customer.builder().name("Todor").email("todor@abv,.bg").address("@home").phoneNumber("2841421").build();

        //Act
        Customer savedCustomer = customerRepository.save(customer);

        //Assert
        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getCustomerId()).isGreaterThan(0);

    }

    @Test
    public void CustomerRepository_GetAll_ReturnMoreThanOneCustomer(){
        Customer customer = Customer.builder().name("Todor").email("todor@abv,.bg").address("@home").phoneNumber("2841421").build();
        Customer customer2 = Customer.builder().name("Petur").email("Petur@abv,.bg").address("@neighbor").phoneNumber("4152788").build();

        customerRepository.save(customer);
        customerRepository.save(customer2);

        List<Customer> customerList = customerRepository.findAll();

        Assertions.assertThat(customerList).isNotNull();
        Assertions.assertThat(customerList.size()).isEqualTo(2);
    }

    @Test
    public void CustomerRepository_FindById_ReturnCustomerWithId(){
        Customer customer = Customer.builder().name("Todor").email("todor@abv,.bg").address("@home").phoneNumber("2841421").build();
        customerRepository.save(customer);
        Customer customerReturn = customerRepository.findById(customer.getCustomerId()).get();

        Assertions.assertThat(customerReturn).isNotNull();



    }





}
