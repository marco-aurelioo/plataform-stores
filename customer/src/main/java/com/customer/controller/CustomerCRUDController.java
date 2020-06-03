package com.customer.controller;

import com.customer.business.CustomerBusiness;
import com.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CustomerCRUDController {

    @Autowired
    private CustomerBusiness customerBusiness;
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        return new ResponseEntity<Customer>( customerBusiness.findCustomerById(id),HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Customer>  createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>( customerBusiness.createCustomer(customer),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Customer>  updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerBusiness.update(customer,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") String id) {
        return new ResponseEntity<Boolean>( customerBusiness.deleteCustomer(id),HttpStatus.OK);
    }

}

