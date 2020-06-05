package com.company.repository;

import com.company.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreCRUdRepository extends CrudRepository<StoreEntity, UUID> {
}
