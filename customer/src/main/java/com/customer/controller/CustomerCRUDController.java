package com.customer.controller;

import com.customer.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CustomerCRUDController {

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        return new ResponseEntity<Customer>( new Customer(),HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Customer>  createCustomer(Customer customer) {
        return new ResponseEntity<Customer>( new Customer(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Customer>  updateCustomer(@PathVariable("id") String id, Customer customer) {
        return new ResponseEntity<Customer>( new Customer(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Customer>  deleteCustomer(@PathVariable("id") String id, Customer customer) {
        return new ResponseEntity<Customer>( new Customer(),HttpStatus.OK);
    }


    public  ResponseEntity<Customer>  partialUpdateCustomer(@PathVariable("id") String id, Customer customer) {
        return new ResponseEntity<Customer>( new Customer(),HttpStatus.OK);
    }


}

