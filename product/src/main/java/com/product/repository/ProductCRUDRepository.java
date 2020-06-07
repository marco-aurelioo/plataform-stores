package com.product.repository;

import com.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCRUDRepository extends CrudRepository<ProductEntity,Long> {
}
