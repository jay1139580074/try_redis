package com.junjie.tryredis.controller;

import com.junjie.tryredis.domain.Customer;
import com.junjie.tryredis.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Add Customer", description = "Add a new customer to the database and cache")
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return  customerService.addCustomer(customer);
    }

    @Operation(summary = "Get Customer by ID", description = "Retrieve a customer by their ID, checking the cache first")
    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }
}
