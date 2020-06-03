package com.customer.repository;

import com.customer.entity.CustomerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerFinderRepository extends PagingAndSortingRepository<CustomerEntity, UUID> {


}
