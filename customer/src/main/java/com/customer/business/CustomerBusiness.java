package com.customer.business;

import ch.qos.logback.classic.jmx.MBeanUtil;
import com.customer.entity.CustomerEntity;
import com.customer.model.Customer;
import com.customer.repository.CustomerCRUDRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.util.BeanDefinitionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerBusiness {

    @Autowired
    private CustomerCRUDRepository repositoryCRUD;

    public Customer createCustomer(Customer customer){
        CustomerEntity entity = fromPojo(customer);
        entity = repositoryCRUD.save(entity);
        Customer createdCustomer = fromEntity(entity);
        return createdCustomer;
    }

    public Boolean deleteCustomer(String uuid){
        UUID id = UUID.fromString(uuid);
        Optional<CustomerEntity> entityOptional = repositoryCRUD.findById(id);
        if(entityOptional.isPresent()){
            repositoryCRUD.delete(entityOptional.get());
            return true;
        }else{
            throw new RuntimeException("Customer not found.");
        }
    }

    public Customer findCustomerById(String uuid){
        UUID id =  UUID.fromString(uuid);
        Optional<CustomerEntity> entityOptional = repositoryCRUD.findById(id);
        if(entityOptional.isPresent()){
            Customer customer = fromEntity(entityOptional.get());
            return customer;
        }else{
            throw new RuntimeException("Customer not found.");
        }
    }

    public Customer update(Customer customer, String uuid) {
        UUID id = UUID.fromString(uuid);
        if(customer.getId().equals(id)) {
            Optional<CustomerEntity> entityOptional = repositoryCRUD.findById(id);
            if(entityOptional.isPresent()){
                CustomerEntity entity = entityOptional.get();
                BeanUtils.copyProperties(customer,entity);
                entity = repositoryCRUD.save(entity);
                Customer custemerUpdated = fromEntity(entity);
                return custemerUpdated;
            }else{
                throw new RuntimeException("Customer not found.");
            }
        }else{
            throw new RuntimeException("incompatible customerId");
        }
    }

    private Customer fromEntity(CustomerEntity entity){
        Customer customer = new Customer();
        BeanUtils.copyProperties(entity,customer);
        return customer;
    }

    private CustomerEntity fromPojo(Customer customer){
        Optional<CustomerEntity> entityOptional = repositoryCRUD.findById(customer.getId());
        CustomerEntity entity = new CustomerEntity();
        if(!entityOptional.isEmpty()) {
            entity = entityOptional.get();
        }
        BeanUtils.copyProperties(customer,entity);
        return entity;
    }
}
