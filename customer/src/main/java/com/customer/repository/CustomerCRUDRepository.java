package com.customer.repository;

import com.customer.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerCRUDRepository extends CrudRepository<CustomerEntity, UUID> {
}
